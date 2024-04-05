package newsonthego;

import newsonthego.newstopic.NewsTopic;
import newsonthego.newstopic.TopicComparator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NewsImporter {

    public static List<NewsArticle> importNewsFromText(String filename, ArrayList<NewsTopic> newsTopics) {
        List<String> newsList = new ArrayList<String>();
        newsList.add("Scientists Discover New Species of Butterfly in the Amazon;John Smith;March 10, 2024;Nature News;https://www.example.com/science/butterfly-discovery;Importance: 8;Reliability: 9;Bias: 2;Science");
        newsList.add("Stock Market Surges to Record Highs Amid Economic Recovery;Emily Johnson;March 11, 2024;Financial Times;https://www.example.com/finance/stock-market-record;Importance: 9;Reliability: 9;Bias: 3;Finance");
        newsList.add("Political Tensions Rise in Region X Following Border Dispute;Samantha Lee;March 12, 2024;The Guardian;https://www.example.com/politics/border-dispute;Importance: 7;Reliability: 8;Bias: 4;Politics");
        newsList.add("Breakthrough in Cancer Research Offers Hope for New Treatment;David Chen;March 13, 2024;Science Daily;https://www.example.com/health/cancer-breakthrough;Importance: 10;Reliability: 9;Bias: 1;Health");
        newsList.add("Tech Giants Announce Partnership to Combat Online Misinformation;Sarah Davis;March 14, 2024;TechCrunch;https://www.example.com/technology/misinformation-partnership;Importance: 9;Reliability: 8;Bias: 3;Technology");
        newsList.add("Local Community Comes Together to Support Homeless Shelter;Michael Johnson;March 15, 2024;Community Gazette;https://www.example.com/community/homeless-support;Importance: 6;Reliability: 7;Bias: 5;Community");
        newsList.add("Climate Change Summit Ends with Disappointing Agreement;Emma Thompson;March 16, 2024;Environmental News Network;https://www.example.com/environment/climate-summit;Importance: 8;Reliability: 9;Bias: 2;Environment");
        newsList.add("New Study Reveals Alarming Decline in Bee Populations;Jessica Miller;March 17, 2024;Science Today;https://www.example.com/environment/bee-decline-study;Importance: 8;Reliability: 8;Bias: 2;Environment");
        newsList.add("Celebrity Couple's Divorce Shocks Fans Worldwide;Andrew Wilson;March 18, 2024;Entertainment Weekly;https://www.example.com/entertainment/celebrity-divorce;Importance: 7;Reliability: 7;Bias: 6;Entertainment");
        newsList.add("Space Agency Plans Mission to Explore Jupiter's Moons;Christopher Adams;March 19, 2024;Space Exploration News;https://www.example.com/space/jupiter-mission;Importance: 9;Reliability: 9;Bias: 2;Space");
        newsList.add("Education Reform Bill Passes in Parliament Amid Controversy;Jennifer Roberts;March 20, 2024;Politics Daily;https://www.example.com/politics/education-reform;Importance: 8;Reliability: 8;Bias: 3;Politics");
        newsList.add("Artificial Intelligence Breakthrough Promises Revolution in Healthcare;Daniel Brown;March 21, 2024;Technology Today;https://www.example.com/technology/ai-healthcare-revolution;Importance: 10;Reliability: 9;Bias: 2;Technology");
        newsList.add("New Documentary Exposes Corruption in Corporate Sector;Rachel Green;March 22, 2024;Investigative Reporters Journal;https://www.example.com/business/corporate-corruption-doc;Importance: 9;Reliability: 9;Bias: 1;Business");
        newsList.add("Rising Star Athlete Sets New World Record in Track and Field;Matthew Johnson;March 23, 2024;Sports Illustrated;https://www.example.com/sports/world-record-athlete;Importance: 8;Reliability: 8;Bias: 4;Sports");
        newsList.add("Investigation Uncovers Fraudulent Practices in Banking Industry;Olivia Taylor;March 24, 2024;Financial Watchdog;https://www.example.com/finance/banking-fraud-investigation;Importance: 9;Reliability: 9;Bias: 2;Finance");
        newsList.add("Festival of Lights Draws Thousands to City's Streets;Sophia Lee;March 25, 2024;Cultural Times;https://www.example.com/culture/festival-lights;Importance: 7;Reliability: 8;Bias: 5;Culture");
        newsList.add("Renewable Energy Initiative Receives Funding Boost;Ethan White;March 26, 2024;Green Energy Gazette;https://www.example.com/environment/renewable-energy-funding;Importance: 8;Reliability: 8;Bias: 3;Environment");
        newsList.add("Historical Artifact Discovered in Archaeological Dig;Benjamin Parker;March 27, 2024;Archaeology Today;https://www.example.com/history/artifact-discovery;Importance: 6;Reliability: 7;Bias: 4;History");
        newsList.add("Fashion Week Showcases Emerging Designers' Talent;Madison Carter;March 28, 2024;Fashion News Daily;https://www.example.com/fashion/fashion-week-designers;Importance: 7;Reliability: 7;Bias: 6;Fashion");
        newsList.add("Local Brewery Wins Prestigious Award for Craft Beer;Jacob Smith;March 29, 2024;Beer Enthusiast Magazine;https://www.example.com/food-drink/brewery-award;Importance: 6;Reliability: 6;Bias: 7;Food & Drink");
        newsList.add("Unemployment Rates Drop to Lowest Levels in a Decade;Rachel Johnson;March 30, 2024;Economic Observer;https://www.example.com/economy/unemployment-rate;Importance: 8;Reliability: 8;Bias: 3;Economy");
        newsList.add("New Legislation Aims to Combat Plastic Pollution in Oceans;Ethan Roberts;March 31, 2024;Environmental Policy Review;https://www.example.com/environment/plastic-pollution-legislation;Importance: 9;Reliability: 9;Bias: 2;Environment");
        newsList.add("Technology Expo Showcases Latest Innovations in Robotics;Nathan Adams;April 2, 2024;Tech Innovations Journal;https://www.example.com/technology/robotics-expo;Importance: 9;Reliability: 8;Bias: 3;Technology");
        newsList.add("Humanitarian Crisis Deepens in Conflict-Stricken Region;Emily Wilson;April 3, 2024;Crisis Watch;https://www.example.com/world/humanitarian-crisis;Importance: 8;Reliability: 8;Bias: 4;Politics");
        newsList.add("Wildfire Devastates Thousands of Acres of Forest Land;Michael Roberts;April 4, 2024;Environmental Crisis Times;https://www.example.com/environment/wildfire-devastation;Importance: 9;Reliability: 9;Bias: 2;Environment");
        newsList.add("Record-Breaking Heatwave Grips Nation, Prompting Safety Warnings;Sophia Williams;April 5, 2024;Weather Watch;https://www.example.com/weather/heatwave-safety;Importance: 9;Reliability: 8;Bias: 3;Environment");
        newsList.add("Documentary Film on Endangered Species Raises Awareness;David Green;April 6, 2024;Conservation Chronicle;https://www.example.com/environment/endangered-species-documentary;Importance: 8;Reliability: 8;Bias: 4;Environment");
        newsList.add("New Theatrical Production Receives Rave Reviews from Critics;Sarah Thompson;April 7, 2024;Theater Times;https://www.example.com/entertainment/theatrical-production;Importance: 7;Reliability: 7;Bias: 5;Entertainment");
        newsList.add("Major Tech Company Announces Plans for Sustainable Data Centers;Jonathan Taylor;April 8, 2024;Tech News Network;https://www.example.com/technology/sustainable-data-centers;Importance: 9;Reliability: 9;Bias: 2;Technology");
        newsList.add("Investigation Reveals Government Officials Involved in Bribery Scandal;Ethan Miller;April 9, 2024;Investigative Post;https://www.example.com/politics/bribery-scandal-investigation;Importance: 9;Reliability: 9;Bias: 2;Politics");
        newsList.add("Local School District Implements Innovative Teaching Methods;Emma Johnson;April 10, 2024;Education Weekly;https://www.example.com/education/innovative-teaching-methods;Importance: 7;Reliability: 8;Bias: 4;Education");
        newsList.add("Rare Lunar Phenomenon Captivates Skygazers Worldwide;Nathan Brown;April 11, 2024;Astronomy Today;https://www.example.com/science/lunar-phenomenon;Importance: 8;Reliability: 8;Bias: 3;Science");
        newsList.add("New Art Installation Transforms City's Downtown District;Isabella Davis;April 12, 2024;Art News Network;https://www.example.com/art/art-installation;Importance: 6;Reliability: 7;Bias: 5;Art");
        newsList.add("Economic Forecast Predicts Slowdown in Growth for Coming Year;Daniel Wilson;April 13, 2024;Economic Outlook;https://www.example.com/finance/economic-forecast;Importance: 8;Reliability: 9;Bias: 3;Finance");
        newsList.add("Youth-Led Climate Activism Movement Gains Momentum;Sophia Adams;April 14, 2024;Climate Action Now;https://www.example.com/environment/climate-activism;Importance: 7;Reliability: 8;Bias: 4;Environment");
        newsList.add("Groundbreaking Medical Procedure Offers Hope for Paralyzed Patients;Michael Thompson;April 15, 2024;Medical Breakthroughs;https://www.example.com/health/medical-procedure-par;Importance: 9;Reliability: 9;Bias: 2;Health");
        newsList.add("Local Food Bank Faces Increased Demand Amid Economic Challenges;Olivia Lee;April 16, 2024;Community News Network;https://www.example.com/community/food-bank-demand;Importance: 6;Reliability: 7;Bias: 5;Community");
        newsList.add("New Study Links Air Pollution to Increased Risk of Heart Disease;Benjamin Green;April 17, 2024;Health & Wellness Journal;https://www.example.com/health/air-pollution-heart-disease;Importance: 8;Reliability: 8;Bias: 4;Health");
        newsList.add("Space Agency Announces Plans for Mission to Mars;Christopher Wilson;April 19, 2024;Space Exploration News;https://www.example.com/space/mars-mission;Importance: 9;Reliability: 9;Bias: 2;Space Exploration");
        newsList.add("New Legislation Aims to Address Housing Crisis in Urban Centers;Ethan Thompson;April 20, 2024;Urban Development Review;https://www.example.com/politics/housing-crisis-legislation;Importance: 8;Reliability: 8;Bias: 3;Politics");
        newsList.add("Local Music Festival Raises Funds for Children's Charity;Isabella Roberts;April 21, 2024;Music News Weekly;https://www.example.com/music/music-festival-charity;Importance: 6;Reliability: 7;Bias: 5;Community");
        newsList.add("Technology Company Faces Backlash Over Data Privacy Concerns;Nathan Green;April 22, 2024;Tech Privacy Watch;https://www.example.com/technology/data-privacy-backlash;Importance: 9;Reliability: 8;Bias: 3;Technology");
        newsList.add("New Study Reveals Alarming Decline in Bee Populations;Jessica Miller;April 23, 2024;Science Today;https://www.example.com/environment/bee-decline-study;Importance: 8;Reliability: 8;Bias: 2;Environment");
        newsList.add("Local Community Comes Together to Support Homeless Shelter;Michael Johnson;April 24, 2024;Community Gazette;https://www.example.com/community/homeless-support;Importance: 6;Reliability: 7;Bias: 5;Community");
        newsList.add("Climate Change Summit Ends with Disappointing Agreement;Emma Thompson;April 25, 2024;Environmental News Network;https://www.example.com/environment/climate-summit;Importance: 8;Reliability: 9;Bias: 2;Environment");
        newsList.add("New Study Reveals Alarming Decline in Goat Populations;Bob Doe;April 26, 2023;Science Today;https://www.example.com/environment/goat-decline-study;Importance: 8;Reliability: 8;Bias: 2;Environment");
        newsList.add("Celebrity Couple's Divorce Shocks Fans Worldwide;Andrew Wilson;April 27, 2024;Entertainment Weekly;https://www.example.com/entertainment/celebrity-divorce;Importance: 7;Reliability: 7;Bias: 6;Entertainment");
        newsList.add("Space Agency Plans Mission to Explore Jupiter's Moons;Christopher Adams;April 28, 2024;Space Exploration News;https://www.example.com/space/jupiter-mission;Importance: 9;Reliability: 9;Bias: 2;Space Exploration");

        List<NewsArticle> list = new ArrayList<>();
        for (String s : newsList) {
            String[] split = s.split(";");
            String headline = split[0];
            String author = split[1];
            String date = split[2];
            String source = split[3];
            String url = split[4];
            int importance = Integer.parseInt(split[5].split(" ")[1]);
            int reliability = Integer.parseInt(split[6].split(" ")[1]);
            int bias = Integer.parseInt(split[7].split(" ")[1]);
            NewsArticle newsArticle = new NewsArticle(headline, author, date, source, importance, reliability, bias);
            list.add(newsArticle);
            //identify related topic to the article
            String topic = split[8];
            boolean topicFound = false;
            //checks against current list of topics
            //if topic is recurring, adds article to the current topic list
            //else, a new topic will be added to the list of topics
            for (NewsTopic t : newsTopics) {
                if (topic.equalsIgnoreCase(t.getTopicName())) {
                    t.addNewsArticle(newsArticle);
                    topicFound = true;
                }
            }
            if (!topicFound) {
                NewsTopic newsTopic = new NewsTopic(topic);
                newsTopic.addNewsArticle(newsArticle);
                newsTopics.add(newsTopic);
            }
        }
        newsTopics.sort(new TopicComparator());
        return list;
    }
}

