package com.mredrock.cyxbs.freshman.model.retrofit;

import java.util.List;

public class ByIdEnity {

    /**
     * status : 0
     * msg : ok
     * result : {"id":600,"classid":4,"name":"燕麦米糊","peoplenum":"1-2人","preparetime":"10分钟内","cookingtime":"10-20分钟","content":"燕麦含碳水化合物，糖类，能迅速为身体提供能量，富含蛋白质，具有维持钾钠平衡，消除水肿，提高免疫力，与大米搭配能起到补血养颜、预防脚气","pic":"http://api.jisuapi.com/recipe/upload/20160719/115350_46230.jpg","tag":"豆浆机,脂肪肝,甜,早餐,排毒,润肠通便,降低胆固醇,助睡眠,消脂,更年期,便秘","material":[{"mname":"糖","type":0,"amount":"少许"},{"mname":"燕麦","type":1,"amount":"50g"},{"mname":"大米","type":1,"amount":"50g"}],"process":[{"pcontent":"所有食材","pic":"http://api.jisuapi.com/recipe/upload/20160719/175817_45704.jpg"},{"pcontent":"大米洗净","pic":"http://api.jisuapi.com/recipe/upload/20160719/175818_90511.jpg"},{"pcontent":"豆浆杯中放水","pic":"http://api.jisuapi.com/recipe/upload/20160719/175818_69068.jpg"},{"pcontent":"放入大米","pic":"http://api.jisuapi.com/recipe/upload/20160719/175819_96358.jpg"},{"pcontent":"再放入燕麦","pic":"http://api.jisuapi.com/recipe/upload/20160719/175820_40298.jpg"},{"pcontent":"盖上盖按米糊键约15分钟","pic":"http://api.jisuapi.com/recipe/upload/20160719/175820_72981.jpg"},{"pcontent":"15分钟后放糖拌匀即可","pic":"http://api.jisuapi.com/recipe/upload/20160719/175820_58501.jpg"}]}
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
         * id : 600
         * classid : 4
         * name : 燕麦米糊
         * peoplenum : 1-2人
         * preparetime : 10分钟内
         * cookingtime : 10-20分钟
         * content : 燕麦含碳水化合物，糖类，能迅速为身体提供能量，富含蛋白质，具有维持钾钠平衡，消除水肿，提高免疫力，与大米搭配能起到补血养颜、预防脚气
         * pic : http://api.jisuapi.com/recipe/upload/20160719/115350_46230.jpg
         * tag : 豆浆机,脂肪肝,甜,早餐,排毒,润肠通便,降低胆固醇,助睡眠,消脂,更年期,便秘
         * material : [{"mname":"糖","type":0,"amount":"少许"},{"mname":"燕麦","type":1,"amount":"50g"},{"mname":"大米","type":1,"amount":"50g"}]
         * process : [{"pcontent":"所有食材","pic":"http://api.jisuapi.com/recipe/upload/20160719/175817_45704.jpg"},{"pcontent":"大米洗净","pic":"http://api.jisuapi.com/recipe/upload/20160719/175818_90511.jpg"},{"pcontent":"豆浆杯中放水","pic":"http://api.jisuapi.com/recipe/upload/20160719/175818_69068.jpg"},{"pcontent":"放入大米","pic":"http://api.jisuapi.com/recipe/upload/20160719/175819_96358.jpg"},{"pcontent":"再放入燕麦","pic":"http://api.jisuapi.com/recipe/upload/20160719/175820_40298.jpg"},{"pcontent":"盖上盖按米糊键约15分钟","pic":"http://api.jisuapi.com/recipe/upload/20160719/175820_72981.jpg"},{"pcontent":"15分钟后放糖拌匀即可","pic":"http://api.jisuapi.com/recipe/upload/20160719/175820_58501.jpg"}]
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
             * mname : 糖
             * type : 0
             * amount : 少许
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
             * pcontent : 所有食材
             * pic : http://api.jisuapi.com/recipe/upload/20160719/175817_45704.jpg
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
