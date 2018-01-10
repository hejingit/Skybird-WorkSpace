package com.baseframe.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baseframe.common.annotation.ServiceLog;
import com.baseframe.common.pojo.AjaxResult;
import com.baseframe.common.pojo.PageAjax;
import com.baseframe.common.utils.AppUtil;
import com.baseframe.common.utils.DateUtil;
import com.baseframe.mapper.IFileMapper;
import com.baseframe.model.IArticle;
import com.baseframe.model.IFile;
import com.github.pagehelper.page.PageMethod;

/**
 * 文件管理
 * ClassName: TechService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年10月17日 下午1:39:37 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version
 */
@Service
public class TechService extends AbstratService<IArticle> {
	
	@Autowired
	private IFileMapper fileMapper;

	@ServiceLog("查询文件列表")
	public PageAjax<IFile> queryFilePage(PageAjax<IFile> page, IFile file) {
		PageMethod.startPage(page.getPageNo(), page.getPageSize());
		List<IFile> list = fileMapper.selectAll();
		return AppUtil.returnPage(list);
	}

	@ServiceLog("新增文件")
	public AjaxResult addFile(IFile file) {
		file.setAddtime(DateUtil.getCurDateTime());
		fileMapper.insert(file);
		return AppUtil.returnObj(null);
	}

	public IFile queryFileByID(int id) {
		return fileMapper.selectByPrimaryKey(id);
	}

	@ServiceLog("更新文件")
	public AjaxResult updateFile(IFile file) {
		fileMapper.updateByPrimaryKeySelective(file);
		return AppUtil.returnObj(null);
	}

	@ServiceLog("删除文件")
	public AjaxResult delFile(int id) {
		IFile file = queryFileByID(id);
		if(null != file){
			fileMapper.deleteByPrimaryKey(id);
			File f = new File(file.getSavepath());
	        if (f.exists()) {
	            f.delete();
	        }
		}
		return AppUtil.returnObj(null);
	}

}
