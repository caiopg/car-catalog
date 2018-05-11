package br.com.caiogandra.carcatalog.completemodellist.view

import br.com.caiogandra.carcatalog.base.BaseView

interface CompleteModelListView: BaseView{
    fun showSummaryDialog(fipeCode: String, year: String)
}