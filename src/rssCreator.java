import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.SyndFeedOutput;
import java.io.*;
import java.util.Arrays;

public class rssCreator
{
    public static SyndFeed feedCreator(String Title, String desc)
    {
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_1.0");
        feed.setTitle(Title);
        feed.setLink("google.com");
        feed.setDescription(desc);
        return feed;
    }

    public static SyndEntry entryCreator(String Title)
    {
        SyndEntry entry = new SyndEntryImpl();
        entry.setTitle(Title);
        entry.setLink("google.com/webhp");
        return entry;
    }

    public static SyndContent descCreator(String desc)
    {
        SyndContent description = new SyndContentImpl();
        description.setType("text/html");
        description.setValue(desc);
        return description;
    }
    public static void main(String[] args)
    {
        SyndFeed f = feedCreator("Tasks", "Tasks for you to complete");
        SyndEntry entry = entryCreator("Drink Water");
        entry.setDescription(descCreator("Nerd"));
        f.setEntries(Arrays.asList(entry));
        try {
            Writer writer = new FileWriter("xyz.xml");
            SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
            syndFeedOutput.output(f, writer);
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.err.println("You done fucked up A-aron");
        }
    }
}
