package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 12:41
 * 邮箱：zyascend@qq.com
 */

public class Notice {

        /**
         * type : 2
         * userType : 1
         * unReadLetterCount : 0
         * unReadOtherCount : 0
         * unReadSysCount : 28
         */

        private int type;
        private int userType;
        private int unReadLetterCount;
        private int unReadOtherCount;
        private int unReadSysCount;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getUnReadLetterCount() {
            return unReadLetterCount;
        }

        public void setUnReadLetterCount(int unReadLetterCount) {
            this.unReadLetterCount = unReadLetterCount;
        }

        public int getUnReadOtherCount() {
            return unReadOtherCount;
        }

        public void setUnReadOtherCount(int unReadOtherCount) {
            this.unReadOtherCount = unReadOtherCount;
        }

        public int getUnReadSysCount() {
            return unReadSysCount;
        }

        public void setUnReadSysCount(int unReadSysCount) {
            this.unReadSysCount = unReadSysCount;
        }
}
