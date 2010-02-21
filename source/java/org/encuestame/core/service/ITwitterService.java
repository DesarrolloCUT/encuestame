/*
 ************************************************************************************
 * Copyright (C) 2001-2010 encuestame: system online surveys Copyright (C) 2010
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */

package org.encuestame.core.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.http.RequestToken;

/**
 * Twitter Service Interface.
 * @author Picado, Juan juan@encuestame.org
 * @since Feb 13, 2010 4:07:14 PM
 * @version $Id$
 */
public interface ITwitterService extends IService{


    /**
     * Get Tiny Url.
     * @param url survey url
     * @return tiny url
     * @throws IOException IOException
     * @throws HttpException HttpExceptio
     */
    String getTinyUrl(final String url) throws HttpException, IOException;

    /**
     * Public Tweet.
     * @param username twitter username
     * @param password twitter password
     * @param tweet text to tweet
     * @return {@link Status}
     * @throws TwitterException twitter exception
     */
    Status publicTweet(final String username, final String password, final String tweet) throws TwitterException;


    /**
     * Get Twitter Ping.
     * @param consumerKey consumer key
     * @param consumerSecret consumer secret
     * @return {@link RequestToken}
     * @throws TwitterException exception
     */
    RequestToken getTwitterPing(String consumerKey, String consumerSecret)
            throws TwitterException;

    /**
     * Verify Credentials.
     * @param username username
     * @param password password
     * @return {@link User}
     * @throws TwitterException exception
     */
    User verifyCredentials(final String username, final String password) throws TwitterException;
}
