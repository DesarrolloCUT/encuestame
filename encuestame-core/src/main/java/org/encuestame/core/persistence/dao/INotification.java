/*
 ************************************************************************************
 * Copyright (C) 2001-2010 encuestame: system online surveys Copyright (C) 2009
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.core.persistence.dao;

import java.util.List;

import org.encuestame.core.persistence.dao.imp.IBaseDao;
import org.encuestame.core.persistence.pojo.SecUser;
import org.encuestame.core.persistence.pojo.notifications.Notification;

/**
 * Implementation for Notification Domain.
 * @author Picado, Juan juanATencuestame.org
 * @since Sep 18, 2010 7:10:54 PM
 * @version $Id:$
 */
public interface INotification extends IBaseDao{

    /**
     * Load Notifications By {@link SecUser} and Limit. This method add all notifications without User (global)
     * @param secUser {@link SecUser}
     * @param limit limit
     * @return
     */
    List<Notification> loadNotificationByUserAndLimit(final SecUser secUser, final Integer limit);

    /**
     * Get Notification.
     * @param notificationId
     * @return
     */
    Notification retrieveNotificationById(final Long notificationId);
}