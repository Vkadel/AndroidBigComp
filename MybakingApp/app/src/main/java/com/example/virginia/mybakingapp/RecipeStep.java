package com.example.virginia.mybakingapp;

public class RecipeStep {
    private int mstepId;
    private String mstepShortDesc;
    private String mstepDesc;
    private String mstepVidURL;
    private String mstepThumburl;

    public RecipeStep(int stepId,String stepShortDesc,String stepDesc,String stepVidURL,String stepThumburl){
        mstepId=stepId;
        mstepShortDesc=stepShortDesc;
        mstepDesc=stepDesc;
        mstepVidURL=stepVidURL;
        mstepThumburl=stepThumburl;
    }

    public void setMstepDesc(String mstepDesc) {
        this.mstepDesc = mstepDesc;
    }

    public void setMstepId(int mstepId) {
        this.mstepId = mstepId;
    }

    public void setMstepShortDesc(String mstepShortDesc) {
        this.mstepShortDesc = mstepShortDesc;
    }

    public void setMstepThumburl(String mstepThumburl) {
        this.mstepThumburl = mstepThumburl;
    }

    public void setMstepVidURL(String mstepVidURL) {
        this.mstepVidURL = mstepVidURL;
    }

    public int getMstepId() {
        return mstepId;
    }

    public String getMstepDesc() {
        return mstepDesc;
    }

    public String getMstepShortDesc() {
        return mstepShortDesc;
    }

    public String getMstepThumburl() {
        return mstepThumburl;
    }

    public String getMstepVidURL() {
        return mstepVidURL;
    }
}
