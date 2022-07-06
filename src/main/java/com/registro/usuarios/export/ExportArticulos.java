package com.registro.usuarios.export;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.registro.usuarios.modelo.Articulo;



public class ExportArticulos {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Articulo> listaArticulos;

	public ExportArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("articulo");
	}

	private void escribirCabeceraDeTabla() {
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);
	
		celda = fila.createCell(1);
		celda.setCellValue("Titulo");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("Autores");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(3);
		celda.setCellValue("Citacion");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(4);
		celda.setCellValue("Pais");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(5);
		celda.setCellValue("Año");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(6);
		celda.setCellValue("Palabras Clave");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(7);
		celda.setCellValue("URL");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(8);
		celda.setCellValue("Resumen");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(9);
		celda.setCellValue("Conclusiones");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(10);
		celda.setCellValue("Notas");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(11);
		celda.setCellValue("Usuario");
		celda.setCellStyle(estilo);
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Articulo articulo : listaArticulos) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(articulo.getId().toString());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
		
			celda = fila.createCell(1);
			celda.setCellValue(articulo.getTitulo());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(articulo.getAutores());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(3);
			celda.setCellValue(articulo.getCitacion());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(4);
			celda.setCellValue(articulo.getPais().toString());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(5);
			celda.setCellValue(articulo.getAnio());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(6);
			celda.setCellValue(articulo.getPalabras_clave());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(7);
			celda.setCellValue(articulo.getUrl());
			hoja.autoSizeColumn(7);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(8);
			celda.setCellValue(articulo.getResumen());
			hoja.autoSizeColumn(8);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(9);
			celda.setCellValue(articulo.getConclusiones());
			hoja.autoSizeColumn(9);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(10);
			celda.setCellValue(articulo.getNotas());
			hoja.autoSizeColumn(10);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(11);
			celda.setCellValue(articulo.getUsuario().toString());
			hoja.autoSizeColumn(11);
			celda.setCellStyle(estilo);
			

		}
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();
		
		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		
		libro.close();
		outPutStream.close();
	}
}