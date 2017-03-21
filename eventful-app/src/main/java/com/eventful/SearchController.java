package com.eventful;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.eventful.search.Convertor;
import com.eventful.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.xml.xpath.XPathExpressionException;

@Controller

public class SearchController {

    @Autowired

    private RestClientService restClientService;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String search(@ModelAttribute("userForm") Search search,
                         Model model) {
        model.addAttribute(MESSAGE, "");
        String response = null;
        try {
            response = restClientService.getStringDataSync(search.getLocation(), search.getKeywords());
            model.addAttribute(SEARCH_RESULT, Convertor.convert(response));
        } catch (XPathExpressionException e) {
            model.addAttribute(MESSAGE, "Could not parse fetched result.");
        } catch (Exception e) {
            model.addAttribute(MESSAGE, "Could not fetch result.");
        }

        return RESULT;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSearchForm(Map<String, Object> model) {
        Search searchForm = new Search();
        searchForm.setLocation("London");
        searchForm.setKeywords("Music");
        model.put(SEARCH_FORM, searchForm);
        return SEARCH;

    }


    private static final String SEARCH_RESULT = "SearchResult";
    private static final String SEARCH_FORM = "searchForm";
    private static final String RESULT = "result";
    private static final String SEARCH = "search";
    private static final String MESSAGE = "message";

}