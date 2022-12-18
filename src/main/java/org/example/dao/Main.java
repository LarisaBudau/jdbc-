package org.example.dao;

import org.example.DatabaseConnection;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        MarketingCampaign myMarketingCampaign = new MarketingCampaign(null, "Name4", Date.valueOf("2022-12-11"), 3579d);
        MarketingCampaignDAO myMarketingCampaignDAO = new MarketingCampaignDAO(DatabaseConnection.getConnection());

        myMarketingCampaignDAO.createTable();
        myMarketingCampaignDAO.initialized();
        // myMarketingCampaignDAO.create(myMarketingCampaign);

        MarketingCampaign marketingCampaign = new MarketingCampaign(null, "Name5", Date.valueOf("2022-12-21"), 10000d);
        myMarketingCampaignDAO.createWithPreparedStatement(marketingCampaign);

        System.out.println(myMarketingCampaignDAO.findAll());

        System.out.println("Lista cu 4 in nume");
        System.out.println(myMarketingCampaignDAO.searchByName("4"));

        System.out.println("Lista cu campanii intre doua perioade de timp este:");
        System.out.println(myMarketingCampaignDAO.searchBetween(Date.valueOf("2022-10-15"), Date.valueOf("2022-12-11")));

    }
}
