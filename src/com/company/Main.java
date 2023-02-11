package com.company;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
	// write your code here

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?muscle=biceps"))
                .header("X-RapidAPI-Key", "088a03c490mshbabdd39f3567b25p1b021ajsnd500a6f71c98")
                .header("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      //  System.out.println(response.body());
        String x = response.body();
        //split string delimited by comma
        String[] stringarray = x.split("},");    //we can use dot, whitespace, any character
        //iterate over string array
        for(int i=0; i< stringarray.length; i++)
        {
        //prints the tokens
            stringarray[i] += "}";
            System.out.println(stringarray[i]);
            System.out.println("_________________________");
        }
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");

        stringarray[0] = stringarray[0].substring(1,stringarray[0].length());
        stringarray[stringarray.length-1] = stringarray[stringarray.length-1].substring(0,stringarray[stringarray.length-1].length()-2);
        System.out.println(stringarray[0]);
        System.out.println("_________________________");
        System.out.println(stringarray[stringarray.length-1]);
        System.out.println("_________________________");

        Exercise[] listExercise = new Exercise[9];
        for(int i=0; i< stringarray.length; i++) {


            String str = stringarray[0];
            str = str.replaceAll("\"name\":", "@!@");
            str = str.replaceAll("\"type\":", "@!@");
            str = str.replaceAll("\"muscle\":", "@!@");
            str = str.replaceAll("\"equipment\":", "@!@");
            str = str.replaceAll("\"difficulty\":", "@!@");
            str = str.replaceAll("\"instructions\":", "@!@");

            str.replaceAll("\"", "");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            System.out.println(str);

            String[] strArr = str.split("@!@");
            for (int k = 1; k < strArr.length; k++) {
                //prints the tokens

//            System.out.println(strArr[i]);
//            System.out.println("_________________________");
                Exercise exercise = new Exercise(strArr[1].substring(2,strArr[1].length()-3), strArr[2].substring(2,strArr[2].length()-3), strArr[3].substring(2,strArr[3].length()-3), strArr[4].substring(2,strArr[4].length()-3), strArr[5].substring(2,strArr[5].length()-3), strArr[6].substring(2,strArr[6].length()-3));

                listExercise[k - 1] = exercise;

            }
        }


        System.out.println(listExercise[3].excerciseToString());















    }
}
