package com.geewhiz.pacify.utils;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class Utils {

	public static String getJarVersion() {
		URL jarURL = Utils.class.getResource("/" + Utils.class.getName().replace(".", "/") + ".class");
		Manifest mf;
		try {
			JarURLConnection jurlConn;
			if (jarURL.getProtocol().equals("file")) {
				return "Not a Jar";
			} else {
				jurlConn = (JarURLConnection) jarURL.openConnection();
			}
			mf = jurlConn.getManifest();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Attributes attr = mf.getMainAttributes();
		return attr.getValue("Implementation-Version");
	}
}