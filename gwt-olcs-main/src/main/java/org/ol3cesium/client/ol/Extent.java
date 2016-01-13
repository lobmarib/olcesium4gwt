/* 
 * Copyright 2016 iserge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ol3cesium.client.ol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Extent extends JavaScriptObject {
    protected Extent() {
        //
    }
    
    public static final native Extent create(double minX, double minY, double maxX, double maxY) /*-{
        return [minX, minY, maxX, maxY];
    }-*/;
    
    public final native double getMinX()/*-{
        return this[0];
    }-*/;

    public final native double getMinY()/*-{
        return this[1];
    }-*/;

    public final native double getMaxX()/*-{
        return this[2];
    }-*/;

    public final native double getMaxY()/*-{
        return this[3];
    }-*/;

    public final native Coordinate getCenter() /*-{
        return ol.extent.getCenter(this);
    }-*/;
    
    public static final native Coordinate getCenter(Extent extent) /*-{
        return ol.extent.getCenter(extent);
    }-*/;
}
