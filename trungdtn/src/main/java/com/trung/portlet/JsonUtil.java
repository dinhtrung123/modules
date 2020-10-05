package com.trung.portlet;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class JsonUtil {
	/** The log. */
	private static final Log LOG = LogFactoryUtil.getLog(JsonUtil.class);

	/**
	 * Instantiates a new json util.
	 */
	private JsonUtil() {
	}

	/**
	 * Convert to json.
	 *
	 * @param <T> the generic type
	 * @param objectList the object list
	 * @return the JSON array
	 */
	public static <T> JSONArray convertToJson(final List<T> objectList) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (T object : objectList) {
			JSONObject jsonObj = JsonUtil.convertToJson(object);
			if (null != jsonObj) {
				jsonArray.put(jsonObj);
			}
		}
		return jsonArray;
	}

	/**
	 * Convert to json.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @return the JSON object
	 */
	public static <T> JSONObject convertToJson(final T object) {
		JSONObject jsonObj = null;

		try {
			if (object != null) {
				jsonObj = JSONFactoryUtil.createJSONObject(JSONFactoryUtil.looseSerialize(object));
			}
		} catch (JSONException e) {
			JsonUtil.LOG.error("Exception occur while converting to creating jsonobject", e);
		}
		return jsonObj;
	}

	/**
	 * Convert to pojo.
	 *
	 * @param <T> the generic type
	 * @param jsonArray the json array
	 * @param clzz the clzz
	 * @return the list
	 */
	public static <T> List<T> convertToPojo(final JSONArray jsonArray, final Class<T> clzz) {
		List<T> objectList = new ArrayList<T>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			T object = JsonUtil.convertToPojo(jsonObject, clzz);
			objectList.add(object);
		}
		return objectList;

	}

	/**
	 * Convert to pojo.
	 *
	 * @param <T> the generic type
	 * @param jsonObject the json object
	 * @param clzz the clzz
	 * @return the t
	 */
	public static <T> T convertToPojo(final JSONObject jsonObject, final Class<T> clzz) {
		if (jsonObject != null) {
			return JSONFactoryUtil.looseDeserialize(jsonObject.toString(), clzz);
		}
		return null;
	}
	
}
