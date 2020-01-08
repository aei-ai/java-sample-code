package ai.aei.api;

import ai.aei.model.Status;
import ai.aei.response.AeiResponse;
import ai.aei.response.ApiCallResponse;
import ai.aei.response.AuthResponse;
import ai.aei.response.InteractionResponse;
import ai.aei.response.PaymentSourceListResponse;
import ai.aei.response.PaymentSourceResponse;
import ai.aei.response.SubscriptionResponse;
import ai.aei.response.UserListResponse;
import ai.aei.response.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * aEi.ai Java API.
 *
 * @author rezaamini Created on 1/1/20
 */
public class AeiApi {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final String AEI_AI_URL = "https://aei.ai";
    private static final String API_VERSION = "v1";
    private static final String API_URL = AEI_AI_URL + "/api/" + API_VERSION;

    /**
     * Registers a new client to the aEi.ai service with given client username, email, and password.
     *
     * @param username Client's username.
     * @param email Client's email.
     * @param password Client's password.
     * @param agreed True if client agreed to the statement of use and privacy policy.
     * @return Response to registration request.
     */
    public static AeiResponse register(String username, String email, String password, boolean agreed) {
        // prepare URL
        String url = AEI_AI_URL + "/register";

        // prepare headers
        Map<String, String> headers = new HashMap<>();
        headers.put("username", username);
        headers.put("email", email);
        headers.put("password", password);
        headers.put("agreed", Boolean.toString(agreed));

        // make an API call to the aEi.ai service to register
        try {
            return post(url, null, null, headers, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Registering new client failed");
            return null;
        }
    }

    /**
     * Logs in to the aEi.ai service with given client username and password.
     *
     * @param username Client's username.
     * @param password Client's password.
     * @return Response to the login request.
     */
    public static AuthResponse login(String username, String password) {
        // prepare URL
        String url = AEI_AI_URL + "/oauth/token";

        // prepare params
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credentials");

        // prepare headers
        Map<String, String> headers = new HashMap<>();
        String credentials = username + ":" + password;
        headers.put("Authorization", "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes()));
        headers.put("Content-Type", "application/x-www-form-urlencoded");

        // make an API call to the aEi.ai service to get access token
        try {
            return post(url, null, params, headers, new TypeReference<AuthResponse>() {});
        } catch (Exception e) {
            System.err.println("Login failed");
            return null;
        }
    }

    /**
     * Creates a new user with given username in aEi.ai service.
     *
     * @param attributes User custom attributes as string key-value pairs.
     * @param accessToken Client's access token.
     * @return Response to the new user creation request.
     */
    public static UserResponse createNewUser(Map<String, String> attributes, String accessToken) {
        // prepare URL
        String url = API_URL + "/users";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // prepare body
        ObjectMapper objectMapper = new ObjectMapper();
        String body = null;
        if (attributes != null && !attributes.isEmpty()) {
            try {
                body = objectMapper.writeValueAsString(attributes);
            } catch (JsonProcessingException e) {
                System.err.println("User attributes are mal-formatted");
            }
        }

        // make an API call to the aEi.ai service to create a new user for user
        try {
            return post(url, body, null, headers, new TypeReference<UserResponse>() {});
        } catch (Exception e) {
            System.err.println("User creation failed");
            return null;
        }
    }

    /**
     * Creates a new aEi.ai interaction for given list of user IDs.
     *
     * @param userIds List of user IDs in new interaction.
     * @param accessToken Client's access token.
     * @return Response to the new interaction request.
     */
    public static InteractionResponse createNewInteraction(List<String> userIds, String accessToken) {
        // prepare URL
        String url = API_URL + "/interactions";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // prepare parameters
        String params = params("user_id", userIds);

        // make an API call to the aEi.ai service to create a new interaction for given user IDs
        try {
            return post(url + params, null, null, headers, new TypeReference<InteractionResponse>() {});
        } catch (Exception e) {
            System.err.println("Interaction creation failed");
            return null;
        }
    }

    /**
     * Gets an interaction with given interaction ID.
     *
     * @param interactionId Target interaction ID.
     * @param accessToken Client's access token.
     * @return Response to getting the interaction.
     */
    public static InteractionResponse getInteraction(String interactionId, String accessToken) {
        // prepare URL
        String url = API_URL + "/interactions/" + interactionId;

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to create a new interaction for given user IDs
        try {
            return get(url, null, headers, new TypeReference<InteractionResponse>() {});
        } catch (Exception e) {
            System.err.println("Getting interaction failed");
            return null;
        }
    }

    /**
     * Adds given user to the given interaction in aEi.ai service.
     *
     * @param interactionId Given interaction ID.
     * @param userIds List of user IDs to add to the interaction.
     * @param accessToken Client's access token.
     * @return Response to adding users to interaction request.
     */
    public static AeiResponse addUsersToInteraction(String interactionId, List<String> userIds, String accessToken) {
        // prepare URL
        String url = API_URL + "/interactions/" + interactionId + "/users";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // prepare parameters
        String params = params("user_id", userIds);

        // make an API call to the aEi.ai service to add a user to interaction
        try {
            return put(url + params, null, null, headers, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Adding users to interaction failed");
            return null;
        }
    }

    /**
     * Sends given user's text to given interaction.
     *
     * @param userId Source user ID.
     * @param interactionId Target interaction ID.
     * @param text User's
     * @param accessToken Client's access token.
     * @return Response to sending a new text input to an interaction.
     */
    public static AeiResponse newTextInput(String userId, String interactionId, String text, String accessToken) {
        // prepare URL
        String url = API_URL + "/inputs/text";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // prepare parameters
        Map<String, String> params = new HashMap<>();
        params.put("user_id", userId);
        params.put("interaction_id", interactionId);

        // prepare body
        String body = "{text: " + text + "}";

        // make an API call to the aEi.ai service to send the new user utterance to the interaction
        try {
            return post(url, body, params, headers, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Sending text input failed");
            return null;
        }
    }

    /**
     * Gets aEi.ai user with given user ID.
     *
     * @param userId Given user ID.
     * @param accessToken Client's access token.
     * @return Response to getting the aEi.ai user.
     */
    public static UserResponse getUser(String userId, String accessToken) {
        // prepare URL
        String url = API_URL + "/users/" + userId;

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to send the new user utterance to the interaction
        try {
            return get(url, null, headers, new TypeReference<UserResponse>() {});
        } catch (Exception e) {
            System.err.println("Getting user failed: " + userId);
            return null;
        }
    }

    /**
     * Gets list of all aEi.ai users of the client.
     *
     * @param accessToken Client's access token.
     * @return Response to getting the aEi.ai user.
     */
    public static UserListResponse getUserList(String accessToken) {
        // prepare URL
        String url = API_URL + "/users/";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to send the new user utterance to the interaction
        try {
            return get(url, null, headers, new TypeReference<UserListResponse>() {});
        } catch (Exception e) {
            System.err.println("Getting user list failed");
            return null;
        }
    }

    /**
     * Gets number of  aEi.ai used free queries of the currently signed in client.
     *
     * @param accessToken Client's access token.
     * @return Response to getting number of used free queries to the aEi.ai API.
     */
    public static ApiCallResponse getUsedFreeQueries(String accessToken) {
        // prepare URL
        String url = API_URL + "/metrics/queries/used";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to get the number of free queries to the the aEi.ai API
        try {
            return get(url, null, headers, new TypeReference<ApiCallResponse>() {});
        } catch (Exception e) {
            System.err.println("Getting used free queries failed");
            return null;
        }
    }

    /**
     * Gets number of aEi.ai used paid queries (in current month) of the currently signed in client.
     *
     * @param accessToken Client's access token.
     * @return Response to getting number of used paid queries to the aEi.ai API.
     */
    public static ApiCallResponse getUsedPaidQueries(String accessToken) {
        // prepare URL
        String url = API_URL + "/metrics/queries";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to get the number of paid queries to the the aEi.ai API
        try {
            return get(url, null, headers, new TypeReference<ApiCallResponse>() {});
        } catch (Exception e) {
            System.err.println("Getting used paid queries failed");
            return null;
        }
    }

    /**
     * Gets the payment method information from Stripe for a given customer.
     *
     * @param accessToken Client's access token.
     * @return Response to getting payment methods.
     */
    public static PaymentSourceListResponse getPaymentSources(String accessToken) {
        // prepare URL
        String url = API_URL + "/sources";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to get payment methods information
        try {
            return get(url, null, headers, new TypeReference<PaymentSourceListResponse>() {});
        } catch (Exception e) {
            System.err.println("Getting payment sources failed");
            return null;
        }
    }

    /**
     * Gets the payment method information from Stripe for a given customer and source Id.
     *
     * @param sourceId Target payment source ID.
     * @param accessToken Client's access token.
     * @return Response to getting a specific payment method information.
     */
    public static PaymentSourceResponse getPaymentSource(String sourceId, String accessToken) {
        // prepare URL
        String url = API_URL + "/sources/" + sourceId;

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to get payment methods information
        try {
            return get(url, null, headers, new TypeReference<PaymentSourceResponse>() {});
        } catch (Exception e) {
            System.err.println("Getting payment source failed: " + sourceId);
            return null;
        }
    }

    /**
     * Adds a payment source ID (previously generated via Stripe API) to the client account.
     *
     * @param accessToken Client's access token.
     * @return Response to adding a payment source ID to client account.
     */
    public static AeiResponse addPaymentSource(String source, String accessToken) {
        // prepare URL
        String url = API_URL + "/sources/" + source;

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to add a payment source to client's account
        try {
            return post(url, null, null, headers, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Adding payment source failed");
            return null;
        }
    }

    /**
     * Get the subscription information for given customer
     *
     * @param accessToken Client's access token.
     * @return Response to getting subscription information.
     */
    public static SubscriptionResponse getSubscription(String accessToken) {
        // prepare URL
        String url = API_URL + "/subscriptions";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to get payment methods information
        try {
            return get(url, null, headers, new TypeReference<SubscriptionResponse>() {});
        } catch (Exception e) {
            System.err.println("Getting subscriptions failed");
            return null;
        }
    }

    /**
     * Updates subscription to the given type.
     *
     * @param accessToken Client's access token.
     * @param subscriptionType Given new subscription type.
     * @return Response to updating subscription.
     */
    public static AeiResponse updateSubscription(String subscriptionType, String accessToken) {
        // prepare URL
        String url = API_URL + "/subscriptions";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // prepare parameters
        Map<String, String> params = new HashMap<>();
        params.put("subscription_type", subscriptionType);

        // make an API call to the aEi.ai service to update the subscription
        try {
            return put(url, null, params, headers, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Updating subscription failed");
            return null;
        }
    }

    /**
     * Deletes a source from Stripe and aEi.ai account given the source ID.
     *
     * @param sourceId Given source ID.
     * @param accessToken Client's access token.
     * @return Response to deleting the payment source with given ID.
     */
    public static AeiResponse deleteSource(String sourceId, String accessToken){
        // prepare URL
        String url = API_URL + "/sources/" + sourceId;

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        // make an API call to the aEi.ai service to update the subscription
        try {
            return del(url, null, headers, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Deleting payment source failed: " + sourceId);
            return null;
        }
    }

    /**
     * Updates a source in Stripe and aEi.ai account given the source ID and parameters to update.
     *
     * @param sourceId Given source ID to update.
     * @param updateParams Key-value params to update as request body.
     * @param accessToken Client's access token.
     * @return Response to updating the payment source.
     */
    public static AeiResponse updateSource(String sourceId, Map<String, String> updateParams, String accessToken) {
        // prepare URL
        String url = API_URL + "/sources/" + sourceId;

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);

        try {
            // prepare body
            String body = body(updateParams);

            // make an API call to the aEi.ai service to update the payment source
            return put(url, body, null, headers, new TypeReference<AeiResponse>() {});
        } catch (JsonProcessingException e) {
            System.err.println("Update parameters conversion failed: " + e);
            return null;
        } catch (Exception e) {
            System.err.println("Updating payment source failed: " + sourceId);
            return null;
        }
    }

    /**
     * Changes aEi.ai account password to the given new password, when use has a valid access token.
     *
     * @param password Given new password.
     * @param accessToken Client's access token.
     * @return Response to changing the password to the given new password.
     */
    public static AeiResponse changePassword(String password, String accessToken) {
        // prepare URL
        String url = API_URL + "/clients/password";

        // prepare headers
        Map<String, String> headers = authHeaders(accessToken);
        headers.put("password", password);

        // make an API call to the aEi.ai service to change password
        try {
            return put(url, null, null, headers, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Changing password failed");
            return null;
        }
    }

    /**
     * Resets aEi.ai account password by sending an email to the client.
     *
     * @param email Client's email.
     * @return Response to sending a password reset email.
     */
    public static AeiResponse resetPassword(String email) {
        // prepare URL
        String url = AEI_AI_URL + "/reset-password";

        // prepare params
        Map<String, String> params = new HashMap<>();
        params.put("email", email);

        // make an API call to the aEi.ai service to reset password
        try {
            return post(url, null, params, null, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Sending password-reset email failed: " + email);
            return null;
        }
    }

    /**
     * Updates aEi.ai account password for the given username and password-reset token.
     *
     * @param username Client's username.
     * @param passwordResetToken Password-reset token provided by server.
     * @param newPassword Client's new password.
     * @return Response to updating client's password.
     */
    public static AeiResponse updatePassword(String username, String passwordResetToken, String newPassword) {
        // prepare URL
        String url = AEI_AI_URL + "/update-password";

        // prepare headers
        Map<String, String> headers = new HashMap<>();
        headers.put("username", username);
        headers.put("token", passwordResetToken);
        headers.put("password", newPassword);

        // make an API call to the aEi.ai service to change password
        try {
            return put(url, null, null, headers, new TypeReference<AeiResponse>() {});
        } catch (Exception e) {
            System.err.println("Updating password failed");
            return null;
        }
    }

    /**
     * Asserts if HTTP response is successful.
     *
     * @param status HTTP response to assert.
     * @return True if response is successful, false otherwise.
     */
    public static boolean isSuccess(Status status) {
        if (status.getCode() != 200) {
            System.err.println(status.getError());
            System.out.println(status.getHelp());
            return false;
        }
        return true;
    }

    private static <T> T get(String url, Map<String, String> params, Map<String, String> headers, TypeReference<T> responseType) throws Exception {
        return execute(new HttpGet(url + params(params)), headers, responseType);
    }

    private static <T> T post(String url, String body, Map<String, String> params, Map<String, String> headers, TypeReference<T> responseType) throws Exception {
        HttpPost request = new HttpPost(url + params(params));
        if (body != null && !body.isEmpty()) {
            request.setEntity(new StringEntity(body));
        }

        return execute(request, headers, responseType);
    }

    private static <T> T put(String url, String body, Map<String, String> params, Map<String, String> headers, TypeReference<T> reseponseType) throws Exception {
        HttpPut request = new HttpPut(url + params(params));
        if (body != null && !body.isEmpty()) {
            request.setEntity(new StringEntity(body));
        }

        return execute(request, headers, reseponseType);
    }

    private static <T> T del(String url, Map<String, String> params, Map<String, String> headers, TypeReference<T> responseType) throws Exception {
        return execute(new HttpDelete(url + params(params)), headers, responseType);
    }

    private static Map<String, String> authHeaders(String accessToken) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + accessToken);
        return headers;
    }

    private static String body(Map<String, String> map) throws JsonProcessingException {
        if (map == null || map.isEmpty()) {
            return "";
        }

        return new ObjectMapper().writeValueAsString(map);
    }

    private static String params(final Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }

        final List<NameValuePair> nameValuePairs = params.keySet().stream()
                .map(key -> new BasicNameValuePair(key, params.get(key))).collect(Collectors.toList());
        return "?" + URLEncodedUtils.format(nameValuePairs, Consts.UTF_8);
    }

    private static String params(String name, final List<String> values) {
        StringBuilder params = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            params.append(i == 0 ? "?" : "&");
            params.append(name);
            params.append("=");
            params.append(values.get(i));
        }
        return params.toString();
    }

    private static <T> T execute(HttpUriRequest request, Map<String, String> headers, TypeReference<T> responseType) throws Exception {
        // add request headers
        for (String header: headers.keySet()) {
            request.addHeader(header, headers.get(header));
        }

        CloseableHttpResponse response = httpClient.execute(request);
        return new ObjectMapper().readValue(response.getEntity().getContent(), responseType);
    }
}
