package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/7/18 10:26
 * 邮箱：zyascend@qq.com
 */

public class MatchComments {

    private String content;
    private String createTime;
    private String id;
    private String matchId;
    private String showTime;
    private int type;
    private MatchDetail.MatchBean.UserBean user;
    private String replyId;
    private ReplyUserBean replyUser;
    private List<?> remindUsers;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public MatchDetail.MatchBean.UserBean getUser() {
        return user;
    }

    public void setUser(MatchDetail.MatchBean.UserBean user) {
        this.user = user;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public ReplyUserBean getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(ReplyUserBean replyUser) {
        this.replyUser = replyUser;
    }

    public List<?> getRemindUsers() {
        return remindUsers;
    }

    public void setRemindUsers(List<?> remindUsers) {
        this.remindUsers = remindUsers;
    }


    public static class ReplyUserBean {
        /**
         * cover : {"height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125}
         * description :
         * finishType : 1
         * gender : -1
         * head : {"height":120,"key":"default_head.png","url":"http://img.nothing.la/default_head.png","webUrl":"//img.nothing.la/default_head.png","width":120}
         * id : 9c22dbea461b4217ab8b5ada7f7bde46
         * name : 张憔悴
         * praise : 0
         * userTitleDesc :
         */

        private MatchDetail.MatchBean.UserBean.CoverBean cover;
        private String description;
        private int finishType;
        private int gender;
        private MatchDetail.MatchBean.UserBean.HeadBean head;
        private String id;
        private String name;
        private int praise;
        private String userTitleDesc;

        public MatchDetail.MatchBean.UserBean.CoverBean getCover() {
            return cover;
        }

        public void setCover(MatchDetail.MatchBean.UserBean.CoverBean cover) {
            this.cover = cover;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getFinishType() {
            return finishType;
        }

        public void setFinishType(int finishType) {
            this.finishType = finishType;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public MatchDetail.MatchBean.UserBean.HeadBean getHead() {
            return head;
        }

        public void setHead(MatchDetail.MatchBean.UserBean.HeadBean head) {
            this.head = head;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPraise() {
            return praise;
        }

        public void setPraise(int praise) {
            this.praise = praise;
        }

        public String getUserTitleDesc() {
            return userTitleDesc;
        }

        public void setUserTitleDesc(String userTitleDesc) {
            this.userTitleDesc = userTitleDesc;
        }


    }
}
