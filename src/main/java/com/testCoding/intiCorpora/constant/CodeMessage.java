package com.testCoding.intiCorpora.constant;

public enum CodeMessage {
    Success_Response{
        @Override
        public String toString(){
            return "Success";
        }
    },
    Data_Unique_Contstraint{
        @Override
        public String toString(){
            return "Data Unique COnstraint";
        }
    },
    Data_Not_Applicable{
        @Override
        public String toString(){
            return "Data Not Applicable";
        }
    }
}
