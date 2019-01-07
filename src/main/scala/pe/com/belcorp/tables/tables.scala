package pe.com.belcorp.tables

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{DataFrame, SparkSession}

object MDMTables {

  class CSVBase(val tipo: String, val path: String) {
    def get(spark: SparkSession): DataFrame = {
      spark.read
        .format("csv")
        .option("header", "true")
        .load(path)
        .select(columnsToSelect: _*)
        .cache()
    }

    def columns: Array[String] = {
      tipo match {
        case "webRedes" => Array[String]("codigo_categoria", "fuente", "codigo_material", "nombre_producto", "desc_larga_producto", "contenido_descripcion_1", "contenido_descripcion_2", "contenido_descripcion_3", "titulo_tip_1", "titulo_tip_2", "titulo_tip_3", "titulo_tip_4", "descripcion_tip_1", "descripcion_tip_2", "descripcion_tip_3", "descripcion_tip_4", "link_video_1", "link_video_2", "link_video_3", "link_video_4", "titulo_paso_1", "titulo_paso_2", "titulo_paso_3", "titulo_paso_4", "descripcion_paso_1", "descripcion_paso_2", "descripcion_paso_3", "descripcion_paso_4")
        case "comunicaciones" => Array[String]("fuente", "codigo_material", "nombre_producto", "nombre_articulo", "capacidad", "desc_producto", "beneficio_slogan")
      }
    }

    val columnsToSelect = columns.map(x => col(x))
  }

}