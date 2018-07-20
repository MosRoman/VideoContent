package com.gmail.morovo1988.Controller;

import com.gmail.morovo1988.DAO.UserService;
import com.gmail.morovo1988.Entity.*;
import com.gmail.morovo1988.Service.ContentService;
import com.gmail.morovo1988.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    static final int DEFAULT_CONTENTT_ID = -1;
    static final int ITEMS_PER_PAGE = 10;


    @Autowired
    private UserService userService;

    @Autowired
    private ContentService contentService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Content> content = contentService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("contents", content);
        model.addAttribute("allPages", getPageCount());
        model.addAttribute("categorys", contentService.findCategorys());
        model.addAttribute("languages", contentService.findLangusges());


        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);

        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());


        return "index";
    }

    @RequestMapping("/admin")
    public String admin(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<CustomUser> customUsers = userService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("customUsers", customUsers);
        model.addAttribute("allPages", getUsersPageCount());

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();


        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());


        return "admin";
    }

    @RequestMapping("/categorys")
    public String categorys(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Category> categories = contentService
                .findAllCategory(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("categories", categories);
        model.addAttribute("allPages", getCategoryPageCount());

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();


        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());


        return "categorys";
    }

    @RequestMapping("/languages")
    public String languages(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Language> languages = contentService
                .findAllLanguage(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("languages", languages);
        model.addAttribute("allPages", getLanguagePageCount());

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();


        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());


        return "languages";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam(required = false) long contents) {
        contentService.deleteContent(contents);
        return "redirect:/";

    }

    @RequestMapping("/delete_category")
    public String deleteCategory(@RequestParam(required = false) long category) {

        Category categ = contentService.findCategory(category);
        List<Content> contents = contentService.findByCategory(categ);
        for (Content content : contents) {
            content.setCategory(null);
            contentService.updateContent(content);
        }
        contentService.deleteCategory(category);
        return "redirect:/categorys";
    }

    @RequestMapping("/delete_language")
    public String deleteLanguage(@RequestParam(required = false) long language) {

        Language lang = contentService.findLanguage(language);
        List<Content> contents = contentService.findByLanguage(lang);
        for (Content content : contents) {
            content.setLanguage(null);
            contentService.updateContent(content);
        }

        contentService.deleteLanguage(language);
        return "redirect:/languages";
    }

    @RequestMapping(value = "/update/content", method = RequestMethod.POST)
    public String update(
            @RequestParam(required = false) long contents,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam(value = "language") long languageId,
            @RequestParam(value = "category") long categoryId,
            @RequestParam String url) {

        Language language = (languageId != DEFAULT_CONTENTT_ID) ? contentService.findLanguage(languageId) : null;
        Category category = (categoryId != DEFAULT_CONTENTT_ID) ? contentService.findCategory(categoryId) : null;


        Content content = contentService.getContentById(contents);

        content.setTitle(title);
        content.setDescription(description);
        content.setCategory(category);
        content.setLanguage(language);
        content.setUrl(url);
        contentService.updateContent(content);


        return "redirect:/";
    }


    @RequestMapping("/update_page")
    public String apdatePage(Model model) {

        model.addAttribute("categorys", contentService.findCategorys());
        model.addAttribute("languages", contentService.findLangusges());
        return "update_page";
    }


    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         Model model) {
        if (userService.existsByLogin(login)) {
            model.addAttribute("exists", true);
            return "register";
        }

        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String passHash = encoder.encodePassword(password, null);

        CustomUser dbUser = new CustomUser(login, passHash, UserRole.USER);
        userService.addUser(dbUser);

        return "redirect:/";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/content_add_page")
    public String productAddPage(Model model) {
        model.addAttribute("categorys", contentService.findCategorys());
        model.addAttribute("languages", contentService.findLangusges());
        return "content_add_page";
    }

    @RequestMapping("/category_add_page")
    public String categoryAddPage() {
        return "category_add_page";
    }

    @RequestMapping("/language_add_page")
    public String languageAddPage() {
        return "language_add_page";
    }


    @RequestMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }


    @RequestMapping(value = "/content/add", method = RequestMethod.POST)
    public String contentAdd(@RequestParam String title,
                             @RequestParam String description,
                             @RequestParam(value = "language") long languageId,
                             @RequestParam(value = "category") long categoryId,
                             @RequestParam String url) {

        Language language = (languageId != DEFAULT_CONTENTT_ID) ? contentService.findLanguage(languageId) : null;
        Category category = (categoryId != DEFAULT_CONTENTT_ID) ? contentService.findCategory(categoryId) : null;

        Content content = new Content(title, description, language, category, url);

        contentService.addContent(content);
        return "redirect:/";
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String categoryAdd(@RequestParam String name) {
        Category category = new Category(name);
        contentService.addCategory(category);
        return "redirect:/categorys";
    }


    @RequestMapping(value = "/language/add", method = RequestMethod.POST)
    public String languageAdd(@RequestParam String name,
                              @RequestParam String shortCode
    ) {
        Language language = new Language(name, shortCode);
        contentService.addLanguage(language);
        return "redirect:/languages";
    }

    @RequestMapping("/category/{id}")
    public String listGroup(
            @PathVariable(value = "id") long categoryId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        Category category = (categoryId != DEFAULT_CONTENTT_ID) ? contentService.findCategory(categoryId) : null;
        if (page < 0) page = 0;

        List<Content> contents = contentService
                .findByCategory(category, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("categorys", contentService.findCategorys());
        model.addAttribute("languages", contentService.findLangusges());
        model.addAttribute("contents", contents);
        model.addAttribute("byCategoryPages", getPageCountCategory(category));
        model.addAttribute("categoryId", categoryId);


        return "index";
    }


    @RequestMapping("/language/{id}")
    public String listGroup2(
            @PathVariable(value = "id") long languageId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        Language language = (languageId != DEFAULT_CONTENTT_ID) ? contentService.findLanguage(languageId) : null;
        if (page < 0) page = 0;

        List<Content> contents = contentService
                .findByLanguage(language, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("categorys", contentService.findCategorys());
        model.addAttribute("languages", contentService.findLangusges());
        model.addAttribute("contents", contents);
        model.addAttribute("byLanguagePages", getPageCountLanguage(language));
        model.addAttribute("categoryId", languageId);


        return "index";
    }


    private long getPageCount() {
        long totalCount = contentService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getUsersPageCount() {
        long totalCount = userService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getCategoryPageCount() {
        long totalCount = contentService.countCategory();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getLanguagePageCount() {
        long totalCount = contentService.countLanguage();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCountLanguage(Language language) {
        long totalCount = contentService.countByLanguage(language);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCountCategory(Category category) {
        long totalCount = contentService.countByCategory(category);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }


}
