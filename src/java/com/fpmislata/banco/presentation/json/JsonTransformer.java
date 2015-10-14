/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentation.json;

/**
 *
 * @author alumno
 */
public interface JsonTransformer {
    String toJson(Object object);
    Object fromJson(String json, Class clazz);
}
