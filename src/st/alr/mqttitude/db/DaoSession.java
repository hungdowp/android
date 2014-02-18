package st.alr.mqttitude.db;

import java.util.Map;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

	private final DaoConfig contactLinkDaoConfig;
	private final DaoConfig waypointDaoConfig;
	private final DaoConfig notificationDaoConfig;

	private final ContactLinkDao contactLinkDao;
	private final WaypointDao waypointDao;
	private final NotificationDao notificationDao;

	public DaoSession(SQLiteDatabase db, IdentityScopeType type,
			Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap) {
		super(db);

		this.contactLinkDaoConfig = daoConfigMap.get(ContactLinkDao.class)
				.clone();
		this.contactLinkDaoConfig.initIdentityScope(type);

		this.waypointDaoConfig = daoConfigMap.get(WaypointDao.class).clone();
		this.waypointDaoConfig.initIdentityScope(type);

		this.notificationDaoConfig = daoConfigMap.get(NotificationDao.class)
				.clone();
		this.notificationDaoConfig.initIdentityScope(type);

		this.contactLinkDao = new ContactLinkDao(this.contactLinkDaoConfig,
				this);
		this.waypointDao = new WaypointDao(this.waypointDaoConfig, this);
		this.notificationDao = new NotificationDao(this.notificationDaoConfig,
				this);

		registerDao(ContactLink.class, this.contactLinkDao);
		registerDao(Waypoint.class, this.waypointDao);
		registerDao(Notification.class, this.notificationDao);
	}

	public void clear() {
		this.contactLinkDaoConfig.getIdentityScope().clear();
		this.waypointDaoConfig.getIdentityScope().clear();
		this.notificationDaoConfig.getIdentityScope().clear();
	}

	public ContactLinkDao getContactLinkDao() {
		return this.contactLinkDao;
	}

	public WaypointDao getWaypointDao() {
		return this.waypointDao;
	}

	public NotificationDao getNotificationDao() {
		return this.notificationDao;
	}

}
