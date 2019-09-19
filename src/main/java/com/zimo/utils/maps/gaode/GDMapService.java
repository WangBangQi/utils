package com.zimo.utils.maps.gaode;


import com.zimo.utils.maps.gaode.exceptions.GdMapException;


/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,1:56 PM
 */
public interface GDMapService {

    <T extends GdMapResponse> T gerGdMapResponse(GdMapRequest<T> request)throws GdMapException;
}
