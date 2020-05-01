package me.surendra.event;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;

import static org.junit.Assert.*;

public class VideoAdUploadRequestEventTest {
//
//    private static String  testVideo = "TestVideoAd.mp4";
//    private static String  dmaVideo = "2018WashingtonDCDMA.mp4";
//    private static TrackableItemNeedsProcessService trackableItemNeedsProcessService;
//    public static void main(final String[] args) {
//        getTrackableItemNeedsProcessService();
//        removeexistingEvent();
//        // raiseNeedsProcessEvent();
//    }
//
//    private static void removeexistingEvent() {
//        final List<NeedsUpdateItem<VideoAdUploadRequestEvent>> needsUpdateItems = trackableItemNeedsProcessService.fetchLimit(VideoAdUploadRequestEvent.VIDEO_AD_UPLOAD_VIDEO_REQUEST, 5, VideoAdUploadRequestEvent.class);
//        needsUpdateItems.forEach(YoutubeTest::markEventDone);
//    }
//    private static void markEventDone(final NeedsUpdateItem<VideoAdUploadRequestEvent> videoAdUploadRequestEventNeedsUpdateItem) {
//        trackableItemNeedsProcessService.done(videoAdUploadRequestEventNeedsUpdateItem);
//    }
//    protected static void raiseNeedsProcessEvent() {
//        //  trackableItemNeedsProcessService.setNeedsProcess(
//        //        VideoAdUploadRequestEvent.VIDEO_AD_UPLOAD_VIDEO_REQUEST,
//        //   VideoAdUploadRequestEvent.create(RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphabetic(5), "http://api-int.dit.connectcdk.com/api/dm-dit-channel-transparency-rest/v1/" + testVideo)
//        //  );
//    }
//    public static void getTrackableItemNeedsProcessService() {
//        final String hzGroup =  "dit-ord-central";
//        final ConnectionConfig centralClusterConnectionConfig = new ConnectionConfig(hzGroup, hzGroup, Lists.newArrayList(Sets.newHashSet(
//            "c03idmdap34.dslab.ad.adp.com:5750",
//            "c03idmdap231.dslab.ad.adp.com:5760",
//            "c03idmdap34.dslab.ad.adp.com:5750",
//            "c03idmdap231.dslab.ad.adp.com:5760",
//            "c03idmdap34.dslab.ad.adp.com:5750",
//            "c03idmdap231.dslab.ad.adp.com:5760"
//        )));
//        final ClientManager clientManager = new ClientManagerImpl(() -> "http://api-int.dit.connectcdk.com/api/dm-event-storage/v1", () -> new ApiUser("dapClient", "d@pCl13nt"));
//        trackableItemNeedsProcessService =  clientManager.getTrackableItemNeedsProcessService("youtube", centralClusterConnectionConfig);
//    }

}
