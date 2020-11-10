package java112.project3.TeamMVC;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NetworkUtils {
    //https://www.googleapis.com/books/v1/volumes?q=hamlet&key=AIzaSyDhPrw23cOfJIzVgzDjsfKbjPgGxP3jH2E

//    https://www.googleapis.com/demo/v1?fields=kind,items(title,characteristics/length)
    // https://www.googleapis.com/books/v1/volumes?q=hamlet&fields=kind,items(volumeInfo(title,authors,publishedDate,imageLinks,description))&key=AIzaSyDhPrw23cOfJIzVgzDjsfKbjPgGxP3jH2E

    private static final String GOOGLE_BOOKS_BASE_URL = "https://www.googleapis.com/books/";
    private static final String GOOGLE_API_NAME = "v1/"; //Google Books API v1
    private static final String BOOK_SEARCH_TYPE = "volumes?"; // search by volume name
    private static final String PARAM_VOLUME_NAME = "q";
    private static final String PARAM_FIELDS = "fields";
    private static final String PARAM_START_INDEX = "startIndex";
    private static final String VAL_FIELDS = "kind,items(volumeInfo(title,authors,publisher,publishedDate,imageLinks,description))";
    private static final String ACCESS_KEY = "key";


    /**
     * Generates formatted URL
     * for further get request
     *
     * @param volumeToSearch user's input on what volume to search
     * @return  formatted get url
     * @throws URISyntaxException uri syntax exception
     */
    public static URL generateURL(String volumeToSearch, String startIndex) {
        String url = GOOGLE_BOOKS_BASE_URL + GOOGLE_API_NAME + BOOK_SEARCH_TYPE;
        HashMap<String, String> params = new HashMap<>();
        params.put(PARAM_VOLUME_NAME, volumeToSearch);
        params.put(PARAM_FIELDS, VAL_FIELDS);
        params.put(PARAM_START_INDEX, startIndex);
        params.put(ACCESS_KEY, "AIzaSyDhPrw23cOfJIzVgzDjsfKbjPgGxP3jH2E");
        URL resultURL = null;
        try {
            resultURL = new URL(appendToUrl(url, params));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return resultURL;
    }

    //    https://stackoverflow.com/questions/26177749/how-can-i-append-a-query-parameter-to-an-existing-url
    private static String appendToUrl(String url, HashMap<String, String> params)
    {
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String query = uri.getQuery();
        StringBuilder builder = new StringBuilder();
        if (query != null)
            builder.append(query);
        for (Map.Entry<String, String> entry: params.entrySet())
        {
            String keyValueParam = entry.getKey() + "=" + entry.getValue();
            if (!builder.toString().isEmpty())
                builder.append("&");
            builder.append(keyValueParam);
        }
        URI formattedURI = null;

        try {
            formattedURI = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), builder.toString(), uri.getFragment());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return formattedURI.toString();
    }

    /**
     * Gets response from the url
     *
     * @param url
     * @return string json of books' data
     * @throws IOException ioEceptyion
     */
    public static String getResponseFromURL(URL url) {
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream(); //open input stream on url
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A"); //split on starting of line; will return the whole line
            boolean hasInput = scanner.hasNext(); //if return smt ? true : false
            if (hasInput) {
                return scanner.next();//read str on in with url data
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }


    public static ArrayList<Book> parseJSONBooks(String booksString) {

        ArrayList<Book> books = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(booksString);
            JSONArray items = obj.getJSONArray("items");

            for (int i = 0; i < items.length(); i++) {
                JSONObject bookJSON = items.getJSONObject(i).getJSONObject("volumeInfo");
                String title = bookJSON.getString("title");

                String[] authors = bookJSON.has("authors")
                        ? bookJSON.getJSONArray("authors").toString().split(",")
                        : new String[]{"no authors"};
                String publisher = bookJSON.has("publisher")
                        ? bookJSON.getString("publisher")
                        : "no publisher";
                String description = bookJSON.has("description")
                        ? bookJSON.getString("description")
                        : "no description";
                String publishedDate = bookJSON.getString("publishedDate");
                String imageThumbnail = bookJSON.getJSONObject("imageLinks").getString("smallThumbnail");

                Book book = new Book(title, authors, description, publisher, publishedDate, imageThumbnail);
                books.add(book);
                System.out.println(book);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return books;
    }

    //For testing
    public static void main(String[] args) {
//        System.out.println(generateURL("dsfdf"));

        URL url = NetworkUtils.generateURL("Hamlet", "30");
        String resultBooks = NetworkUtils.getResponseFromURL(url);
        ArrayList<Book> bks = parseJSONBooks(resultBooks);
        System.out.println(bks);
    }
}
