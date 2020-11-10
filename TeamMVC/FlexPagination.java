package java112.project3.TeamMVC;

import java.util.*;

public class FlexPagination {

    public static String generatePages(int currentPage, int totalItems, String searchVal){
        int cpCurrentPage = currentPage;
        int left = 5;
        int right = 5;
        ArrayList<String> flexPagesStr = new ArrayList<>();
        TreeMap<Integer, String> flexPages = new TreeMap<>();


        String page = "<a href='http://localhost:8080/java112/testTeamMVCServlet?currentPage=%d&searchVal=%s'>%d</a>";
        flexPages.put(cpCurrentPage, String.format("<a href='http://localhost:8080/java112/testTeamMVCServlet?currentPage=%d&searchVal=%s&active=true'>%d</a>",
                cpCurrentPage, searchVal, cpCurrentPage));

        while(cpCurrentPage > 1 && left > 0){
            flexPages.put(--cpCurrentPage, String.format(page, cpCurrentPage, searchVal, cpCurrentPage));
            left--;
        }
        right += left;
        cpCurrentPage = currentPage;

        while(cpCurrentPage < totalItems/10 && right > 0){
            flexPages.put(++cpCurrentPage, String.format(page, cpCurrentPage, searchVal, cpCurrentPage));
            right--;
        }
        String startPoint = String.format("<a href='http://localhost:8080/java112/testTeamMVCServlet?currentPage=%d&searchVal=%s'>%s</a>", 0, searchVal, "START");
        String endPoint = String.format("<a href='http://localhost:8080/java112/testTeamMVCServlet?currentPage=%d&searchVal=%s'>%s</a>", totalItems/10, searchVal, "END");

        return startPoint + "\t" + flexPages.values().toString() + "\t" + endPoint;
    }

    public static void main(String[] args) {
        System.out.println(FlexPagination.generatePages(7, 1000, "Hamlet"));
    }
}
