/*
 ************************************************************************************
 * Copyright (C) 2001-2011 encuestame: system online surveys Copyright (C) 2011
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.rest.api.v1.chart;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.encuestame.mvc.controller.AbstractJsonControllerV1;
import org.encuestame.persistence.domain.survey.Poll;
import org.encuestame.persistence.domain.tweetpoll.TweetPoll;
import org.encuestame.util.exception.EnMeNoResultsFoundException;
import org.encuestame.utils.web.PollBeanResult;
import org.encuestame.utils.web.TweetPollResultsBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TweetPoll Json Data Chart.
 * @author Picado, Juan juanATencuestame.org
 * @since Sep 15, 2010 10:30:29 AM
 */
@Controller
public class JsonDataChart extends AbstractJsonControllerV1 {

    /**
     * Log.
     */
    private static Log log = LogFactory.getLog(JsonDataChart.class);

    /**
     * JSON service to retrieve vote of a {@link Poll}.
     * @param username username
     * @param pollId poll id.
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/api/{username}/poll/votes.json", method = RequestMethod.GET)
    public @ResponseBody ModelMap getPollVotes(
            @PathVariable String username,
            @RequestParam(value = "id") Long pollId,
            HttpServletRequest request, HttpServletResponse response)
            throws JsonGenerationException, JsonMappingException, IOException {
        log.debug("PollId " + pollId);
        log.debug("PollId " + (pollId instanceof Long));
        // TODO: we need check if user able to display this tweetpoll. eg. If is
        // published or if is public
        //this.getTweetPollVotesStore(pollId, response);
        try {
            final Map<String, Object> jsonResult = new HashMap<String, Object>();
            //results by tweetpoll id.
            log.debug("poll =============================== ");
            final Poll poll = getPollService().getPollById(pollId, username);
            log.debug("poll ================= " + poll);
            final List<PollBeanResult> results = getPollService().getResultVotes(poll);
            log.debug("poll PollBeanResult results " + results.size());
            jsonResult.put("votesResult", results);
            log.debug("Poll results " + results.size());
            setItemResponse(jsonResult);
        } catch (EnMeNoResultsFoundException e) {
            log.equals(e);
            setError(e.getMessage(), response);
        }
        return returnData();
    }


    /**
     * Get votes for {@link TweetPoll}.
     * @param username
     * @param tweetPollId
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/api/{username}/tweetpoll/votes.json", method = RequestMethod.GET)
    public @ResponseBody ModelMap get(@PathVariable String username,
            @RequestParam(value = "tweetPollId") Long tweetPollId,
            HttpServletRequest request, HttpServletResponse response)
            throws JsonGenerationException, JsonMappingException, IOException {
        log.debug("TweetPollId " + tweetPollId);
        log.debug("TweetPollId " + (tweetPollId instanceof Long));
        // TODO: we need check if user able to display this tweetpoll. eg. If is
        // published or if is public
        this.getTweetPollVotesStore(tweetPollId, response);
        return returnData();
    }

    /**
     *
     * @param username
     * @param id
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/api/{username}/tweetpoll/{id}/votes.json", method = RequestMethod.GET)
    public @ResponseBody ModelMap getVotes(
            @PathVariable String username,
            @PathVariable Long id,
            HttpServletRequest request, HttpServletResponse response)
            throws JsonGenerationException, JsonMappingException, IOException {
        // TODO: we need check if user able to display this tweetpoll. eg. If is
        // published or if is public
        this.getTweetPollVotesStore(id, response);
        return returnData();
    }

    /**
     *
     * @param username
     * @param id
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/api/tweetpoll/{username}/answer/{id}/votes.json", method = RequestMethod.GET)
    public @ResponseBody ModelMap getAnswerVotes(
            @PathVariable String username,
            @PathVariable Long id,
            HttpServletRequest request, HttpServletResponse response)
            throws JsonGenerationException, JsonMappingException, IOException {
        // TODO: we need check if user able to display this tweetpoll. eg. If is
        // published or if is public
        //this.getVotesStore(id, response); //TODO: response votes for only 1 answer.
        final Map<String, Object> jsonResponse = new HashMap<String, Object>();
        setItemResponse(jsonResponse);
        return returnData();
    }

    /**
     * Retrieve a list of votes of one tweetpoll.
     * @param tweetPollId tweetpoll id.
     * @param request {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @PreAuthorize("hasRole('ENCUESTAME_USER')")
    @RequestMapping(value = "/api/chart/tweetpoll/votes.json", method = RequestMethod.GET)
    public @ResponseBody ModelMap getVotes(
            @RequestParam(value = "tweetPollId") Long tweetPollId,
            HttpServletRequest request, HttpServletResponse response)
            throws JsonGenerationException, JsonMappingException, IOException {
        log.debug("TweetPollId " + tweetPollId);
        log.debug("TweetPollId " + (tweetPollId instanceof Long));
        // TODO: we need check if user able to display this tweetpoll. eg. If is
        // published or if is public
        this.getTweetPollVotesStore(tweetPollId, response);
        return returnData();
    }

    /**
     * Get tweetpoll votes store.
     * @param tweetPollId tweetpoll id
     * @param response {@link HttpServletResponse}.
     */
    private void getTweetPollVotesStore(
            final Long tweetPollId,
            final HttpServletResponse response) {
        try {
            final Map<String, Object> jsonResult = new HashMap<String, Object>();
            //results by tweetpoll id.
            final List<TweetPollResultsBean> results = getTweetPollService().getResultsByTweetPollId(tweetPollId);
            jsonResult.put("votesResult", results);
            log.debug("TweetPoll results " + results.size());
            setItemResponse(jsonResult);
        } catch (EnMeNoResultsFoundException e) {
            log.equals(e);
            setError(e.getMessage(), response);
        }
    }
}
