package org.olcesium.olcs;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import ol.Feature;
import ol.View;
import ol.geom.Circle;
import ol.geom.Geometry;
import ol.geom.LineString;
import ol.geom.Point;
import ol.geom.Polygon;
import ol.layer.Image;
import ol.layer.Layer;
import ol.proj.Projection;
import ol.style.Style;
import ol.style.StyleFunction;
import ol.style.Text;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.BillboardCollection;
import org.cesiumjs.cs.collections.LabelCollection;
import org.cesiumjs.cs.collections.PrimitiveCollection;
import org.cesiumjs.cs.scene.Material;
import org.cesiumjs.cs.scene.Primitive;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.olcesium.olcsx.core.OlFeatureToCesiumContext;

/**
 * Created by mribeiro on 21/08/19.
 */
@JsType(isNative = true, namespace = "olcs", name = "FeatureConverter")
public class FeatureConverter {

    @JsConstructor
    public FeatureConverter(Scene scene){}

    /**
     * Convert an OpenLayers circle geometry to Cesium.
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {!ol.Feature} feature Ol3 feature..
     * @param {!ol.geom.Circle} olGeometry Ol3 circle geometry.
     * @param {!ol.proj.ProjectionLike} projection
     * @param {!ol.style.Style} olStyle
     * @return {!Cesium.PrimitiveCollection} primitives
     * @api
     */
    @JsMethod
    public native PrimitiveCollection olCircleGeometryToCesium(Image layer, Feature feature, Circle circle, ol.proj.Projection projection, Style style);

    /**
     * Convert an OpenLayers line string geometry to Cesium.
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {!ol.Feature} feature Ol3 feature..
     * @param {!ol.geom.LineString} olGeometry Ol3 line string geometry.
     * @param {!ol.proj.ProjectionLike} projection
     * @param {!ol.style.Style} olStyle
     * @return {!Cesium.PrimitiveCollection} primitives
     * @api
     */
    @JsMethod
    public native PrimitiveCollection olLineStringGeometryToCesium(Layer layer, Feature feature, LineString lineString, Projection projection, Style style);

    /**
     * Convert an OpenLayers polygon geometry to Cesium.
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {!ol.Feature} feature Ol3 feature..
     * @param {!ol.geom.Polygon} olGeometry Ol3 polygon geometry.
     * @param {!ol.proj.ProjectionLike} projection
     * @param {!ol.style.Style} olStyle
     * @return {!Cesium.PrimitiveCollection} primitives
     * @api
     */
    @JsMethod
    public native PrimitiveCollection olPolygonGeometryToCesium(Layer layer, Feature feature, Polygon polygon, Projection projection, Style style);

    /**
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {ol.Feature} feature Ol3 feature..
     * @param {!ol.geom.Geometry} geometry
     * @return {!Cesium.HeightReference}
     * @api
     */
    public native HeightReference getHeightReference(Layer layer, Feature feature, Geometry geometry);

    /**
     * Convert a point geometry to a Cesium BillboardCollection.
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {!ol.Feature} feature Ol3 feature..
     * @param {!ol.geom.Point} olGeometry Ol3 point geometry.
     * @param {!ol.proj.ProjectionLike} projection
     * @param {!ol.style.Style} style
     * @param {!Cesium.BillboardCollection} billboards
     * @param {function(!Cesium.Billboard)=} opt_newBillboardCallback Called when
     * the new billboard is added.
     * @return {Cesium.Primitive} primitives
     * @api
     */
    @JsMethod
    public native Primitive olPointGeometryToCesium(Layer layer, Feature feature, Point point, Projection projection, Style style, BillboardCollection billboards, Cesium.Function callback);

    /**
     * Convert an OpenLayers multi-something geometry to Cesium.
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {!ol.Feature} feature Ol3 feature..
     * @param {!ol.geom.Geometry} geometry Ol3 geometry.
     * @param {!ol.proj.ProjectionLike} projection
     * @param {!ol.style.Style} olStyle
     * @param {!Cesium.BillboardCollection} billboards
     * @param {function(!Cesium.Billboard)=} opt_newBillboardCallback Called when
     * the new billboard is added.
     * @return {Cesium.Primitive} primitives
     * @api
     */
    @JsMethod
    public native Primitive olMultiGeometryToCesium(Layer layer, Feature feature, Geometry geometry, Projection projection, Style style, BillboardCollection billboards, Cesium.Function callback);

    /**
     * Convert an OpenLayers text style to Cesium.
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {!ol.Feature} feature Ol3 feature..
     * @param {!ol.geom.Geometry} geometry
     * @param {!ol.style.Text} style
     * @return {Cesium.LabelCollection} Cesium primitive
     * @api
     */
    @JsMethod
    public native LabelCollection olGeometry4326TextPartToCesium(Layer layer, Feature feature, Geometry geometry, Text style);


    /**
     * Convert an OpenLayers style to a Cesium Material.
     * @param {ol.Feature} feature Ol3 feature..
     * @param {!ol.style.Style} style
     * @param {boolean} outline
     * @return {Cesium.Material}
     * @api
     */
    @JsMethod
    public native Material olStyleToCesium(Feature feature, Style style, boolean outline);

    /**
     * Compute OpenLayers plain style.
     * Evaluates style function, blend arrays, get default style.
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {!ol.Feature} feature
     * @param {ol.style.StyleFunction|undefined} fallbackStyleFunction
     * @param {number} resolution
     * @return {ol.style.Style} null if no style is available
     * @api
     */
    @JsMethod
    public native Style computePlainStyle(Layer layer, Feature feature, StyleFunction styleFunction, int resolution);

    /**
     * Convert one OpenLayers feature up to a collection of Cesium primitives.
     * @param {ol.layer.Vector|ol.layer.Image} layer
     * @param {!ol.Feature} feature Ol3 feature.
     * @param {!ol.style.Style} style
     * @param {!olcsx.core.OlFeatureToCesiumContext} context
     * @param {!ol.geom.Geometry=} opt_geom Geometry to be converted.
     * @return {Cesium.Primitive} primitives
     * @api
     */
    @JsMethod
    public native Primitive olFeatureToCesium(Layer layer, Feature feature, Style style, OlFeatureToCesiumContext context, Geometry geometry);

    /**
     * Convert an OpenLayers vector layer to Cesium primitive collection.
     * For each feature, the associated primitive will be stored in
     * `featurePrimitiveMap`.
     * @param {!(ol.layer.Vector|ol.layer.Image)} olLayer
     * @param {!ol.View} olView
     * @param {!Object.<number, !Cesium.Primitive>} featurePrimitiveMap
     * @return {!olcs.core.VectorLayerCounterpart}
     * @api
     //TODO: object VectorLayerCounterpart not implemented
     @JsMethod
    public native VectorLayerCounterpart olVectorLayerToCesium(Layer layer, View view, Map<Integer, Primitive> featurePrimitiveMap);*/

    /**
     * Convert an OpenLayers feature to Cesium primitive collection.
     * @param {!(ol.layer.Vector|ol.layer.Image)} layer
     * @param {!ol.View} view
     * @param {!ol.Feature} feature
     * @param {!olcsx.core.OlFeatureToCesiumContext} context
     * @return {Cesium.Primitive}
     * @api
     */
    @JsMethod
    public native Primitive convert(Layer layer, View view, Feature feature, OlFeatureToCesiumContext context);
}
