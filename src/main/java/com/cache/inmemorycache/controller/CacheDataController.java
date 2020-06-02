package com.cache.inmemorycache.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cache.inmemorycache.impl.CacheDataService;
import com.cache.inmemorycache.pojo.CacheData;

import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;

@RestController
public class CacheDataController {

	final static Logger logger = LoggerFactory.getLogger(CacheDataController.class);

	@Autowired
	private CacheDataService cacheDataService;

	@ApiOperation(value = "Save Cache data")
	@RequestMapping(value = "/cache/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveCacheDataData(@RequestBody CacheData cacheData, HttpServletResponse response) {
		try {
			cacheData = cacheDataService.saveCacheDataData(cacheData);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(cacheData);
	}

	@ApiOperation(value = "Find Cache data")
	@RequestMapping(value = "/cache/find/{cache_key}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CacheData> findCacheDataData(@PathVariable(value = "cache_key") String key, HttpServletResponse response) {
		List<CacheData> list = null;
		try {
			list = cacheDataService.findCacheDataData(key);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@ApiOperation(value = "Update Cache data")
	@RequestMapping(value = "/cache/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updatCacheDataData(@RequestBody CacheData cacheData, HttpServletResponse response) {
		try {
			cacheData = cacheDataService.updatCacheDataData(cacheData);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(cacheData);
	}

	@ApiOperation(value = "Delete Cache data")
	@RequestMapping(value = "/cache/delete/{cache_key}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> removeCacheDataData(@PathVariable(value = "cache_key") String index,
			HttpServletResponse response) {
		JSONObject responseJSON = new JSONObject();
		try {
			cacheDataService.removeCacheDataData(index);
			responseJSON.put("status", "SUCCESS");
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(responseJSON.toString());
	}

	@ApiOperation(value = "Service Check link")
	@RequestMapping(value = "/servicecheck", method = RequestMethod.GET)
	public String servicecheck() {
		return "This is the First Message From Remote in-memory-cache!";
	}
}
