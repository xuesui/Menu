package com.mredrock.cyxbs.freshman.model.retrofit;

import java.util.List;

public class SearchEnity {

    /**
     * status : 0
     * msg : ok
     * result : {"num":1,"list":[{"id":99,"classid":2,"name":"冬瓜丸子汤","peoplenum":"1-2人","preparetime":"10-20分钟","cookingtime":"10-20分钟","content":"冬瓜丸子汤是我很喜欢的汤，冬瓜味甘、淡、性凉，入肺、大肠、小肠、膀胱经； 具有润肺生津，化痰止渴，利尿消肿，清热祛暑，解毒排脓等等的功效；<br />一个很清淡的汤也可以很美味，丸子加入香菇芹菜还有红萝卜不仅口感好，味道也特别的香。","pic":"http://api.jisuapi.com/recipe/upload/20160719/115155_10101.jpg","tag":"减肥,利尿,利水消肿,水肿","material":[{"mname":"油","type":0,"amount":"适量"},{"mname":"盐","type":0,"amount":"适量"},{"mname":"香菇","type":0,"amount":"3个"},{"mname":"红萝卜","type":0,"amount":"30g"},{"mname":"芹菜","type":0,"amount":"20g"},{"mname":"姜","type":0,"amount":"2片"},{"mname":"冬瓜","type":1,"amount":"400g"},{"mname":"肉沫","type":1,"amount":"80g"}],"process":[{"pcontent":"准备好的材料","pic":"http://api.jisuapi.com/recipe/upload/20160719/162901_84978.jpg"},{"pcontent":"红萝卜、芹菜、香菇、姜片剁成茸","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_49421.jpg"},{"pcontent":"把所有的材料加入肉末中剁均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_52945.jpg"},{"pcontent":"加入半茶匙糖、1茶匙盐","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_71578.jpg"},{"pcontent":"继续剁均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_93800.jpg"},{"pcontent":"剁好的肉饼加入油朝一个方向搅拌均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_60616.jpg"},{"pcontent":"锅里加入冬瓜翻炒片刻","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_21164.jpg"},{"pcontent":"加入鸡汤小火煮","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_87151.jpg"},{"pcontent":"丸子用手挤出后用勺子取出放入锅里，全部丸子加入后调成大火","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_59438.jpg"},{"pcontent":"待全部丸子浮起，再下盐调味即可","pic":"http://api.jisuapi.com/recipe/upload/20160719/162904_87420.jpg"}]}]}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * num : 1
         * list : [{"id":99,"classid":2,"name":"冬瓜丸子汤","peoplenum":"1-2人","preparetime":"10-20分钟","cookingtime":"10-20分钟","content":"冬瓜丸子汤是我很喜欢的汤，冬瓜味甘、淡、性凉，入肺、大肠、小肠、膀胱经； 具有润肺生津，化痰止渴，利尿消肿，清热祛暑，解毒排脓等等的功效；<br />一个很清淡的汤也可以很美味，丸子加入香菇芹菜还有红萝卜不仅口感好，味道也特别的香。","pic":"http://api.jisuapi.com/recipe/upload/20160719/115155_10101.jpg","tag":"减肥,利尿,利水消肿,水肿","material":[{"mname":"油","type":0,"amount":"适量"},{"mname":"盐","type":0,"amount":"适量"},{"mname":"香菇","type":0,"amount":"3个"},{"mname":"红萝卜","type":0,"amount":"30g"},{"mname":"芹菜","type":0,"amount":"20g"},{"mname":"姜","type":0,"amount":"2片"},{"mname":"冬瓜","type":1,"amount":"400g"},{"mname":"肉沫","type":1,"amount":"80g"}],"process":[{"pcontent":"准备好的材料","pic":"http://api.jisuapi.com/recipe/upload/20160719/162901_84978.jpg"},{"pcontent":"红萝卜、芹菜、香菇、姜片剁成茸","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_49421.jpg"},{"pcontent":"把所有的材料加入肉末中剁均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_52945.jpg"},{"pcontent":"加入半茶匙糖、1茶匙盐","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_71578.jpg"},{"pcontent":"继续剁均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_93800.jpg"},{"pcontent":"剁好的肉饼加入油朝一个方向搅拌均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_60616.jpg"},{"pcontent":"锅里加入冬瓜翻炒片刻","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_21164.jpg"},{"pcontent":"加入鸡汤小火煮","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_87151.jpg"},{"pcontent":"丸子用手挤出后用勺子取出放入锅里，全部丸子加入后调成大火","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_59438.jpg"},{"pcontent":"待全部丸子浮起，再下盐调味即可","pic":"http://api.jisuapi.com/recipe/upload/20160719/162904_87420.jpg"}]}]
         */

        private int num;
        private List<ListBean> list;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 99
             * classid : 2
             * name : 冬瓜丸子汤
             * peoplenum : 1-2人
             * preparetime : 10-20分钟
             * cookingtime : 10-20分钟
             * content : 冬瓜丸子汤是我很喜欢的汤，冬瓜味甘、淡、性凉，入肺、大肠、小肠、膀胱经； 具有润肺生津，化痰止渴，利尿消肿，清热祛暑，解毒排脓等等的功效；<br />一个很清淡的汤也可以很美味，丸子加入香菇芹菜还有红萝卜不仅口感好，味道也特别的香。
             * pic : http://api.jisuapi.com/recipe/upload/20160719/115155_10101.jpg
             * tag : 减肥,利尿,利水消肿,水肿
             * material : [{"mname":"油","type":0,"amount":"适量"},{"mname":"盐","type":0,"amount":"适量"},{"mname":"香菇","type":0,"amount":"3个"},{"mname":"红萝卜","type":0,"amount":"30g"},{"mname":"芹菜","type":0,"amount":"20g"},{"mname":"姜","type":0,"amount":"2片"},{"mname":"冬瓜","type":1,"amount":"400g"},{"mname":"肉沫","type":1,"amount":"80g"}]
             * process : [{"pcontent":"准备好的材料","pic":"http://api.jisuapi.com/recipe/upload/20160719/162901_84978.jpg"},{"pcontent":"红萝卜、芹菜、香菇、姜片剁成茸","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_49421.jpg"},{"pcontent":"把所有的材料加入肉末中剁均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_52945.jpg"},{"pcontent":"加入半茶匙糖、1茶匙盐","pic":"http://api.jisuapi.com/recipe/upload/20160719/162902_71578.jpg"},{"pcontent":"继续剁均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_93800.jpg"},{"pcontent":"剁好的肉饼加入油朝一个方向搅拌均匀","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_60616.jpg"},{"pcontent":"锅里加入冬瓜翻炒片刻","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_21164.jpg"},{"pcontent":"加入鸡汤小火煮","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_87151.jpg"},{"pcontent":"丸子用手挤出后用勺子取出放入锅里，全部丸子加入后调成大火","pic":"http://api.jisuapi.com/recipe/upload/20160719/162903_59438.jpg"},{"pcontent":"待全部丸子浮起，再下盐调味即可","pic":"http://api.jisuapi.com/recipe/upload/20160719/162904_87420.jpg"}]
             */

            private int id;
            private int classid;
            private String name;
            private String peoplenum;
            private String preparetime;
            private String cookingtime;
            private String content;
            private String pic;
            private String tag;
            private List<MaterialBean> material;
            private List<ProcessBean> process;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getClassid() {
                return classid;
            }

            public void setClassid(int classid) {
                this.classid = classid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPeoplenum() {
                return peoplenum;
            }

            public void setPeoplenum(String peoplenum) {
                this.peoplenum = peoplenum;
            }

            public String getPreparetime() {
                return preparetime;
            }

            public void setPreparetime(String preparetime) {
                this.preparetime = preparetime;
            }

            public String getCookingtime() {
                return cookingtime;
            }

            public void setCookingtime(String cookingtime) {
                this.cookingtime = cookingtime;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public List<MaterialBean> getMaterial() {
                return material;
            }

            public void setMaterial(List<MaterialBean> material) {
                this.material = material;
            }

            public List<ProcessBean> getProcess() {
                return process;
            }

            public void setProcess(List<ProcessBean> process) {
                this.process = process;
            }

            public static class MaterialBean {
                /**
                 * mname : 油
                 * type : 0
                 * amount : 适量
                 */

                private String mname;
                private int type;
                private String amount;

                public String getMname() {
                    return mname;
                }

                public void setMname(String mname) {
                    this.mname = mname;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }
            }

            public static class ProcessBean {
                /**
                 * pcontent : 准备好的材料
                 * pic : http://api.jisuapi.com/recipe/upload/20160719/162901_84978.jpg
                 */

                private String pcontent;
                private String pic;

                public String getPcontent() {
                    return pcontent;
                }

                public void setPcontent(String pcontent) {
                    this.pcontent = pcontent;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }
            }
        }
    }
}
