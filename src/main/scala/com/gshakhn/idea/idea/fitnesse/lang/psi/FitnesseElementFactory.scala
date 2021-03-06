package com.gshakhn.idea.idea.fitnesse.lang.psi

import java.lang.String
import com.intellij.psi.PsiFileFactory
import com.gshakhn.idea.idea.fitnesse.lang.filetype.FitnesseFileType
import com.intellij.openapi.project.Project

object FitnesseElementFactory {
  def createFile(project: Project, text : String) = PsiFileFactory.getInstance(project).createFileFromText(FitnesseFileType.FILE_NAME, FitnesseFileType.INSTANCE, text).asInstanceOf[FitnesseFile]

  def createFixtureClass(project : Project, className : String) = {
    val text = "|" + className + "|"
    val file = createFile(project, text)
    file.getTables(0).getFixtureClass
  }

  def createDecisionInput(project : Project, methodName : String) = {
    val text = "|SomeClass|\n|" + methodName + "|\n"
    val file = createFile(project, text)
    file.getTables(0).getRows(1).getCells(0).asInstanceOf[DecisionInput]
  }
}
