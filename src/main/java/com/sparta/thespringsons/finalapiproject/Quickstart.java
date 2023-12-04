package com.sparta.thespringsons.finalapiproject;//package com.example.demomongo2;
//
//import static com.mongodb.client.model.Filters.eq;
//import org.bson.Document;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//public class Quickstart {
//    public static void main( String[] args ) {
//        // Replace the placeholder with your MongoDB deployment's connection string
//        String uri = "mongodb+srv://Sparta:sparta@mflix.5sg6nqi.mongodb.net/?retryWrites=true&w=majority";
//        try (MongoClient mongoClient = MongoClients.create(uri)) {
//            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
//            MongoCollection<Document> collection = database.getCollection("movies");
//            Document doc = collection.find(eq("title", "Back to the Future")).first();
//            if (doc != null) {
//                System.out.println(doc.toJson());
//            } else {
//                System.out.println("No matching documents found.");
//            }
//        }
//    }
//}