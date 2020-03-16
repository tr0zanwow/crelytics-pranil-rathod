package com.example.crelytics_pranilrathod.DataModels;

import java.io.Serializable;
import java.util.ArrayList;

public class JSONInputModel implements Serializable {
    private float mean_balance;
    private float median_balance;
    private float min_balance;
    private float mode_debit;
    private float mode_credit;
    private float avgsal;
    private float avgach;
    private int total_bounces;
    private ArrayList<RawDataModel> rawData;
    private ArrayList<?> bounce_tranx;

    public JSONInputModel() {
    }

    public static class RawDataModel implements Serializable {
        private float balance;
        private float credit;
        private String date;
        private float debit;
        private int id;
        private String narration;
        private float amt;
        private String category;

        public RawDataModel() {
        }

        public float getBalance() {
            return balance;
        }

        public void setBalance(float balance) {
            this.balance = balance;
        }

        public float getCredit() {
            return credit;
        }

        public void setCredit(float credit) {
            this.credit = credit;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public float getDebit() {
            return debit;
        }

        public void setDebit(float debit) {
            this.debit = debit;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNarration() {
            return narration;
        }

        public void setNarration(String narration) {
            this.narration = narration;
        }

        public float getAmt() {
            return amt;
        }

        public void setAmt(float amt) {
            this.amt = amt;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }

    public ArrayList getBounce_tranx() {
        return bounce_tranx;
    }

    public void setBounce_tranx(ArrayList bounce_tranx) {
        this.bounce_tranx = bounce_tranx;
    }

    public float getMean_balance() {
        return mean_balance;
    }

    public void setMean_balance(float mean_balance) {
        this.mean_balance = mean_balance;
    }

    public float getMedian_balance() {
        return median_balance;
    }

    public void setMedian_balance(float median_balance) {
        this.median_balance = median_balance;
    }

    public float getMin_balance() {
        return min_balance;
    }

    public void setMin_balance(float min_balance) {
        this.min_balance = min_balance;
    }

    public float getMode_debit() {
        return mode_debit;
    }

    public void setMode_debit(float mode_debit) {
        this.mode_debit = mode_debit;
    }

    public float getMode_credit() {
        return mode_credit;
    }

    public void setMode_credit(float mode_credit) {
        this.mode_credit = mode_credit;
    }

    public float getAvgsal() {
        return avgsal;
    }

    public void setAvgsal(float avgsal) {
        this.avgsal = avgsal;
    }

    public float getAvgach() {
        return avgach;
    }

    public void setAvgach(float avgach) {
        this.avgach = avgach;
    }

    public int getTotal_bounces() {
        return total_bounces;
    }

    public void setTotal_bounces(int total_bounces) {
        this.total_bounces = total_bounces;
    }

    public ArrayList<RawDataModel> getRawData() {
        return rawData;
    }

    public void setRawData(ArrayList<RawDataModel> rawData) {
        this.rawData = rawData;
    }
}
