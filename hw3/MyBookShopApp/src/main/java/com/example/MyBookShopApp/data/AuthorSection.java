package com.example.MyBookShopApp.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorSection {

    private List<Author> authorName;

    public AuthorSection() {
    }

    public AuthorSection(List<Author> authorName) {
        this.authorName = authorName;
    }

    public static List<String> getNames() {
        String htmlFile = parseFile("D:\\Java\\Test\\src\\main\\resources\\authors.html");
        List<String> list = new ArrayList<>();
        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.getElementsByClass("Authors-item");

        for (Element element : elements) {
            list.add(element.text());
        }
        return list;
    }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            list.forEach(s -> builder.append(s).append("\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public Map<String, AuthorSection> authorsMap() {
        Map<String, AuthorSection> map = new HashMap<>();
        List<Author> list1 = new ArrayList<>();
        List<Author> list2 = new ArrayList<>();
        List<Author> list3 = new ArrayList<>();
        List<Author> list4 = new ArrayList<>();
        List<Author> list5 = new ArrayList<>();
        List<Author> list6 = new ArrayList<>();
        List<Author> list7 = new ArrayList<>();
        List<Author> list8 = new ArrayList<>();
        List<Author> list9 = new ArrayList<>();
        List<Author> list10 = new ArrayList<>();
        List<Author> list11 = new ArrayList<>();
        List<Author> list12 = new ArrayList<>();
        List<Author> list13 = new ArrayList<>();
        List<Author> list14 = new ArrayList<>();
        List<Author> list15 = new ArrayList<>();
        List<Author> list16 = new ArrayList<>();
        List<Author> list17 = new ArrayList<>();
        List<Author> list18 = new ArrayList<>();
        List<Author> list19 = new ArrayList<>();
        List<Author> list20 = new ArrayList<>();
        List<Author> list21 = new ArrayList<>();
        List<Author> list22 = new ArrayList<>();
        List<Author> list23 = new ArrayList<>();
        List<Author> list24 = new ArrayList<>();
        List<Author> list25 = new ArrayList<>();
        List<Author> list26 = new ArrayList<>();
        List<Author> list27 = new ArrayList<>();
        List<Author> list28 = new ArrayList<>();
        List<Author> list29 = new ArrayList<>();
        List<Author> list30 = new ArrayList<>();
        for (String str:getNames()) {
            String firstLetter = str.replaceAll("[^А-Я].+", "");
            if (firstLetter.equals("А")) {
                list1.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list1));
            }
            if (firstLetter.equals("Б")) {
                list2.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list2));
            }
            if (firstLetter.equals("В")) {
                list3.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list3));
            }
            if (firstLetter.equals("Г")) {
                list4.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list4));
            }
            if (firstLetter.equals("Д")) {
                list5.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list5));
            }
            if (firstLetter.equals("Е")) {
                list6.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list6));
            }
            if (firstLetter.equals("Ё")) {
                list7.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list7));
            }
            if (firstLetter.equals("Ж")) {
                list8.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list8));
            }
            if (firstLetter.equals("З")) {
                list9.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list9));
            }
            if (firstLetter.equals("И")) {
                list10.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list10));
            }
            if (firstLetter.equals("Й")) {
                list11.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list11));
            }
            if (firstLetter.equals("К")) {
                list12.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list12));
            }
            if (firstLetter.equals("Л")) {
                list13.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list13));
            }
            if (firstLetter.equals("М")) {
                list14.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list14));
            }
            if (firstLetter.equals("Н")) {
                list15.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list15));
            }
            if (firstLetter.equals("О")) {
                list16.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list16));
            }
            if (firstLetter.equals("П")) {
                list17.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list17));
            }
            if (firstLetter.equals("Р")) {
                list18.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list18));
            }
            if (firstLetter.equals("С")) {
                list19.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list19));
            }
            if (firstLetter.equals("Т")) {
                list20.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list20));
            }
            if (firstLetter.equals("У")) {
                list21.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list21));
            }
            if (firstLetter.equals("Ф")) {
                list22.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list22));
            }
            if (firstLetter.equals("Х")) {
                list23.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list23));
            }
            if (firstLetter.equals("Ц")) {
                list24.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list24));
            }
            if (firstLetter.equals("Ч")) {
                list25.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list25));
            }
            if (firstLetter.equals("Ш")) {
                list26.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list26));
            }
            if (firstLetter.equals("Щ")) {
                list27.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list27));
            }
            if (firstLetter.equals("Э")) {
                list28.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list28));
            }
            if (firstLetter.equals("Ю")) {
                list29.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list29));
            }
            if (firstLetter.equals("Я")) {
                list30.add(new Author(str));
                map.put(firstLetter, new AuthorSection(list30));
            }
        }
        return map;
    }

    public List<Author> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(List<Author> authorName) {
        this.authorName = authorName;
    }
}
