package com.karros.track.profiler.api.application.constant;

public interface ApplicationConstant {
	/* H2 QUERIES */
	public static final String GET_LATEST_TRACK_HISTORIES_H2_QUERY =
			"select th.track_history_id, th.file_name, th.user_name, th.upload_time from track_history th order by th.upload_time desc \n-- #pageable\n";
	
	/* DATE FORMAT PATTERNS */
	public static final String LOCAL_DATE_TIME_FORMAT_PATTERN_1 = "yyyy-MM-dd HH:mm:ss.SSS";
}
