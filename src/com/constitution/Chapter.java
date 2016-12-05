package com.constitution;

/**
 * Created by MATQ on 2016-12-05.
 */

public class Chapter {
        private int NumFirstArticle;
        private int NumLastArticle;
        private String Title;

        public Chapter() {
        }

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
}

