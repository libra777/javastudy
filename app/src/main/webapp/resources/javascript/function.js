$(document).ready(function(){
	$('body').addClass('jquery');

	$('textarea.markitup').markItUp({
		onShiftEnter:	{keepDefault:false, replaceWith:'<br />\n'},
		onCtrlEnter:	{keepDefault:false, openWith:'\n<p>', closeWith:'</p>'},
		onTab:			{keepDefault:false, replaceWith:'    '},
		markupSet:  [
			{name:'Heading 1', className:'h1', key:'1', openWith:'<h1>', closeWith:'</h1>' },
			{name:'Heading 2', className:'h2', key:'2', openWith:'<h2>', closeWith:'</h2>' },
			{name:'Heading 3', className:'h3', key:'3', openWith:'<h3>', closeWith:'</h3>' },
			{name:'Heading 4', className:'h4', key:'4', openWith:'<h4>', closeWith:'</h4>' },
			{name:'Heading 5', className:'h5', key:'5', openWith:'<h5>', closeWith:'</h5>' },
			{name:'Heading 6', className:'h6', key:'6', openWith:'<h6>', closeWith:'</h6>' },
			{separator:'---------------' },
			{name:'Bold', className:'bold', key:'B', openWith:'<strong>', closeWith:'</strong>' },
			{name:'Italic', className:'italic', key:'I', openWith:'<em>', closeWith:'</em>'  },
			{name:'Strikethrough', className:'strike', key:'S', openWith:'<del>', closeWith:'</del>' },
			{separator:'---------------' },
			{name:'Bulleted List', className: 'ul', openWith:'    <li>', closeWith:'</li>', multiline:true, openBlockWith:'<ul>\n', closeBlockWith:'\n</ul>'},
			{name:'Numeric List', className: 'ol', openWith:'    <li>', closeWith:'</li>', multiline:true, openBlockWith:'<ol>\n', closeBlockWith:'\n</ol>'},
			{separator:'---------------' },
			{name:'Picture', className:'img', key:'P', replaceWith:'<img src="[![Source:!:http://]!]" alt="[![Alternative text]!]" />' },
			{name:'Link', className:'link', key:'L', openWith:'<a href="[![Link:!:http://]!]"(!( title="[![Title]!]")!)>', closeWith:'</a>', placeHolder:'Your text to link...' },
			{separator:'---------------' },
			{name:'Clean', className:'clean', replaceWith:function(markitup) { return markitup.selection.replace(/<(.*?)>/g, ""); } },		
			{name:'Preview', className:'preview',  call:'preview'}
		]
	});
	
	$('textarea.markItUpEditor').wrap('<div class="textarea-wrap" />');
	
	$('table.sortable').tablesorter({
		headers:{
            0:{
				sorter: false
            },
            4:{
				sorter: false
            }
        }
	});
});