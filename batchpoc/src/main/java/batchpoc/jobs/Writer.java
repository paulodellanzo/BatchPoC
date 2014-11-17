package batchpoc.jobs;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import batchpoc.model.ETransaction;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Writer implements ItemWriter<ETransaction>{

    @Autowired
    private EntityManager entityManager;//aca va el dao

    @Override
    public void write(List<? extends ETransaction> items) throws Exception {
/*
        if(items.get(0) != null){
            SuggestedPodcast suggestedPodcast = items.get(0);

            //first insert the data in the database
            Podcast podcast = suggestedPodcast.getPodcast();

            podcast.setInsertionDate(new Date());
            entityManager.persist(podcast);
            entityManager.flush();

            //notify submitter about the insertion and post a twitt about it
            String url = buildUrlOnPodcastpedia(podcast);

            emailNotificationService.sendPodcastAdditionConfirmation(
                    suggestedPodcast.getName(), suggestedPodcast.getEmail(),
                    url);
            if(podcast.getTwitterPage() != null){
                socialMediaService.postOnTwitterAboutNewPodcast(podcast,
                        url);
            }
        }*/

    }

}
