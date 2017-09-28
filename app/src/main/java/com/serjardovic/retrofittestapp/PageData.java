package com.serjardovic.retrofittestapp;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

import java.util.List;

public class PageData {

        @SerializedName("images")
        @Expose
        private List<String> images = null;
        @SerializedName("next_page")
        @Expose
        private int nextPage;
        @SerializedName("current_page")
        @Expose
        private int currentPage;

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

    }