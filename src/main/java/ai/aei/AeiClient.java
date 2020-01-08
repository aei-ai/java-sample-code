package ai.aei;

import ai.aei.api.AeiApi;
import ai.aei.model.Pad;
import ai.aei.model.User;
import ai.aei.response.AeiResponse;
import ai.aei.response.AuthResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 'Hello World' sample code which demonstrates how to invoke aEi.ai Java API.
 *
 * @author rezaamini Created on 1/1/20
 */
public class AeiClient {

    // replace username with your username
    private static final String USERNAME = "<YOUR USERNAME>";
    // replace email with your email
    private static final String EMAIL = "<YOUR EMAIL>";
    // replace password with your password
    private static final String PASSWORD = "<YOUR PASSWORD>";
    // change registered to false if you have not registered an account in aEi.ai yet
    private static final boolean REGISTERED = true;

    public static void main(String[] args) throws Exception {
        // replace user1Id and user2Id with IDs of users you had created before
        // if you have not created users before, set user1Id and user2Id to null
        String user1Id = null; // OR "<1ST USER ID>"
        String user2Id = null; // OR "<2nd USER ID>"
        // replace interactionId with Id of an interaction you had created before
        // if you have not created an interaction before, set interactionId to null
        String interactionId = null; // OR "<INTERACTION ID>"

        // register a new user (if you don't have an account in aEi.ai yet)
        if (!REGISTERED) {
            AeiResponse response = AeiApi.register(USERNAME, EMAIL, PASSWORD, true);
            if (!AeiApi.isSuccess(response.getStatus())) {
                System.exit(1);
            }
        }

        // login (authentication)
        AuthResponse authResponse = AeiApi.login(USERNAME, PASSWORD);
        String accessToken = authResponse.getAccess_token();
        System.out.println("Access token: " + accessToken);

        // create two users
        if (user1Id == null) {
            user1Id = AeiApi.createNewUser(null, accessToken).getUser().getUserId();
            System.out.println("User1 ID: " + user1Id);
        }
        if (user2Id == null) {
            user2Id = AeiApi.createNewUser(null, accessToken).getUser().getUserId();
            System.out.println("User2 ID: " + user2Id);
        }

        // create an interaction and add users to it
        if (interactionId == null) {
            List<String> userIds = new ArrayList<>();
            userIds.add(user1Id);
            userIds.add(user2Id);
            interactionId = AeiApi.createNewInteraction(userIds, accessToken).getInteraction().getInteractionId();
            System.out.println("Interaction ID: " + interactionId);
        }

        // send an utterance by user1 to the interaction
        String text = "I am happy";
        AeiResponse response = AeiApi.newTextInput(user1Id, interactionId, text, accessToken);
        if (!AeiApi.isSuccess(response.getStatus())) {
            System.exit(1);
        }

        // get all user models
        List<User> users = AeiApi.getUserList(accessToken).getUsers();
        // NOTICE: user1 says she is happy, and user2 empathizes with her (e.g., check out emotion pleasure scores)
        for(User user : users) {
            Pad pad = user.getAffect().getEmotion().getPad();
            System.out.printf("User[%s] ", user.getUserId());
            System.out.printf("Emotion PAD: (%1.2f, %1.2f, %1.2f)\n", pad.getPleasure(), pad.getArousal(), pad.getDominance());
        }

        // check how many free queries you've made until now
        long queries = AeiApi.getUsedFreeQueries(accessToken).getQueries();
        System.out.println("Free queries: " + queries);
    }
}
