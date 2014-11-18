package batchpoc.jobs;

import batchpoc.model.ItemCSV;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ItemCSVFieldSetMapper implements FieldSetMapper<ItemCSV> {

    @Override
    public ItemCSV mapFieldSet(FieldSet fieldSet) throws BindException {

        ItemCSV itemCSV = new ItemCSV();
        itemCSV.setColumna01(fieldSet.readString("columna01"));
        itemCSV.setColumna02(fieldSet.readString("columna02"));
        itemCSV.setColumna03(fieldSet.readString("columna03"));
        itemCSV.setColumna04(fieldSet.readString("columna04"));
        itemCSV.setColumna05(fieldSet.readString("columna05"));
        itemCSV.setColumna06(fieldSet.readString("columna06"));
        itemCSV.setColumna07(fieldSet.readString("columna07"));
        itemCSV.setColumna08(fieldSet.readString("columna08"));
        itemCSV.setColumna09(fieldSet.readString("columna09"));
/*
        suggestedPodcast.setCategories(fieldSet.readString("CATEGORIES"));
        suggestedPodcast.setEmail(fieldSet.readString("EMAIL_SUBMITTER"));
        suggestedPodcast.setName(fieldSet.readString("NAME_SUBMITTER"));
        suggestedPodcast.setTags(fieldSet.readString("KEYWORDS"));

        //some of the attributes we can map directly into the Podcast entity that we'll insert later into the database
        Podcast podcast = new Podcast();
        podcast.setUrl(fieldSet.readString("FEED_URL"));
        podcast.setIdentifier(fieldSet.readString("IDENTIFIER_ON_PODCASTPEDIA"));
        podcast.setLanguageCode(LanguageCode.valueOf(fieldSet.readString("LANGUAGE")));
        podcast.setMediaType(MediaType.valueOf(fieldSet.readString("MEDIA_TYPE")));
        podcast.setUpdateFrequency(UpdateFrequency.valueOf(fieldSet.readString("UPDATE_FREQUENCY")));
        podcast.setFbPage(fieldSet.readString("FB_PAGE"));
        podcast.setTwitterPage(fieldSet.readString("TWITTER_PAGE"));
        podcast.setGplusPage(fieldSet.readString("GPLUS_PAGE"));

        suggestedPodcast.setPodcast(podcast);
*/
        return itemCSV;
    }


}
