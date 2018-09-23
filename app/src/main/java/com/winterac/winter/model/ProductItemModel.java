package com.winterac.winter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductItemModel {

    private String title;
    private String title2;
    private List<CategoryItemModel> categoryItems;
    private HashMap<String, ArrayList<CategoryItemModel>> categoryHashMap;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public List<CategoryItemModel> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<CategoryItemModel> categoryItems) {
        this.categoryItems = categoryItems;
    }

    public HashMap<String, ArrayList<CategoryItemModel>> getCategoryHashMap() {
        return categoryHashMap;
    }

    public void setCategoryHashMap(HashMap<String, ArrayList<CategoryItemModel>> categoryHashMap) {
        this.categoryHashMap = categoryHashMap;
    }
}
