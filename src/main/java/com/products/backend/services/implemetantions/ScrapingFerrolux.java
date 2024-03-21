package com.products.backend.services.implemetantions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapingFerrolux {

//    private static final String URL_BASE = "https://ferrolux.com.ar";
//
//    public static void main(String[] args) {
//        // Obtener la lista de URLs de productos
//        List<String> urlsProductos = obtenerEnlacesProductosFerrolux(URL_BASE + "/productos/todos");
//
//        // Extraer los datos de un producto específico
//        String urlProducto = URL_BASE + "/ficha/producto/1674";
//        Map<String, String> datosProducto = extraerAtributosProducto(urlProducto);
//
//        // Imprimir la información del producto
//        System.out.println(datosProducto);
//    }

    private static List<String> obtenerEnlacesProductosFerrolux(String url) {
        try {
            // Realizar la petición GET
            Document doc = Jsoup.connect(url).get();

            // Seleccionar los elementos que contienen los enlaces
            Elements elementosH4 = doc.select("h4");
            Elements elementosImagen = elementosH4;

            // Lista para almacenar las URLs
            List<String> urlsProductos = new ArrayList<>();

            for (Element elementoH4 : elementosH4) {
                Elements elementoA = elementoH4.select("a");

                if (elementoA != null) {
                    String href = elementoA.attr("href");

                    if (!href.isEmpty()) {
                        urlsProductos.add(href);
                    } else {
                        System.out.println("No se encontró 'href' en el elemento: " + elementoA);
                    }
                }
            }

            return urlsProductos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Map<String, String> extraerAtributosProducto(String urlProducto) {
        try {
            // Realizar la petición GET
            Document doc = Jsoup.connect(urlProducto).get();

            // Seleccionar el elemento que contiene la información del producto
            Element ficha = doc.getElementById("ficha");

            // Extraer los datos
            String codigoProducto = ficha.select("h1").text();
            String portaLampara = ficha.select("ul").select("li").text();
            String estilo = ficha.select("h2").text();
            String descripcion = ficha.select("p.descripcion").text();
            String precio = "";

            // Extraer colores
            List<String> colores = new ArrayList<>();
            for (Element liColor : ficha.select(".list-inline-item")) {
                String color = liColor.attr("style");

                if (!color.isEmpty()) {
                    colores.add(color);
                }
            }

            // Extraer URLs de las imágenes
            List<String> urlsImagenes = new ArrayList<>();
            for (Element img : ficha.select("img.sp-thumbnail")) {
                String urlImagen = img.attr("data-src");

                if (!urlImagen.isEmpty()) {
                    urlsImagenes.add(urlImagen);
                }
            }

            // Crear un mapa con los datos del producto
            Map<String, String> datosProducto = new HashMap<>();
            datosProducto.put("codigo_producto", codigoProducto);
            datosProducto.put("portaLampara", portaLampara);
            datosProducto.put("descripcion", descripcion);
            datosProducto.put("colores", String.join(",", colores));
            datosProducto.put("estilo", estilo);
            datosProducto.put("urls_imagenes", String.join(",", urlsImagenes));
            datosProducto.put("precio", precio);
            datosProducto.put("url_producto", urlProducto);
            datosProducto.put("lista", "iluminacion");

            return datosProducto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
