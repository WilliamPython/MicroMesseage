/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}
/**
 * 调用后台单个删除方法
 */
function deleteOne(basePath) {
	$("#mainForm").attr("action",basePath + "DeleteOneServlet.action");
	$("#mainForm").submit();
}
/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}