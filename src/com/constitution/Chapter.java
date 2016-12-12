package com.constitution;

/**
 * Created by MATQ on 2016-12-05.
 */

public class Chapter {
        private int NumFirstArticle;
        private int NumLastArticle;
        private String Title;
        private int NumChapter;

        public Chapter(int NumFirstArticle, int NumLastArticle, int NumChapter, String Title) {
            this.NumFirstArticle = NumFirstArticle;
            this.NumLastArticle = NumLastArticle;
            this.NumChapter = NumChapter;
            this.Title = Title;
        }

        public Chapter(){};

        public void SetFirstArticle(int NumFirstArticle) {
            this.NumFirstArticle = NumFirstArticle;
        }

        public void SetLastArticle(int NumLastArticle) {
            this.NumLastArticle = NumLastArticle;
        }

        public int ReturnNumFirstArticle() {
            return NumFirstArticle;
        }

        public int ReturnNumLastArticle() {
            return NumLastArticle;
        }

        public void SetTitle(String Title) {
            this.Title = Title;
        }

        public String ReturnTitle() {
            return Title;
        }

        public void SetNumChapter (int NumChapter){
            this.NumChapter = NumChapter;
        }
        public int ReturnNumChapter (int NumChapter){
            return this.NumChapter;
        }
}

