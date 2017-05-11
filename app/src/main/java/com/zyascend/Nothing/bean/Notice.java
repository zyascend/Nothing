package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 12:41
 * 邮箱：zyascend@qq.com
 */

public class Notice extends BaseResponse {


    /**
     * DATA : {"list":[{"type":2,"userType":1,"unReadLetterCount":0,"unReadOtherCount":0,"unReadSysCount":42},{"type":1,"unReadLetterCount":0,"unReadOtherCount":0,"unReadSysCount":42}]}
     * MESSAGE : 成功
     * STATUS : 1
     */

    private DATABean DATA;

    public DATABean getDATA() {
        return DATA;
    }

    public void setDATA(DATABean DATA) {
        this.DATA = DATA;
    }

    public static class DATABean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * type : 2
             * userType : 1
             * unReadLetterCount : 0
             * unReadOtherCount : 0
             * unReadSysCount : 42
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
    }
}
