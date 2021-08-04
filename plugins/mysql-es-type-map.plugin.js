'use strict';
var gcoder = require('gcoder');

var MysqlEsTypeMapFilterPlugin = module.exports = gcoder.Plugin.extend({
    constructor: function () {
    }
});

MysqlEsTypeMapFilterPlugin.prototype.do = function (tables,config) {
    MysqlEsTypeMapFilterPlugin.__super__.do();
    let tsTypeMap = {
        "int":"keyword",
        "tinyint":"keyword",
        "smallint":"keyword",
        "bigint":"keyword",
        "mediumint":"keyword",
        "int unsigned":"keyword",
        "float":"keyword",
        "double":"keyword",
        "decimal":"keyword",
        "date":"Date",
        "datetime":"Date",
        "timestamp":"Date",
        "char":"keyword",
        "varchar":"keyword",
        "text":"text",
        "longtext":"text",
        "tinytext":"text",
    }

    console.log("tables contains"+ JSON.stringify(tables));

    for(let table of tables){
        let splitArray = table.tableName.split("_");
        let abbr = "";
        for(let splitStr of splitArray){
            abbr+=splitStr.substr(0,1);
        }
        table.abbr = abbr;
        table.prefix = table.tableName.split("_")[0];
        for(let field of table.fieldArray){
            let fieldType = field.fieldType.replace(/\(\d+,\d\)/,"");
            field.esType = tsTypeMap[fieldType];
            if(!field.esType){
                console.log(`${field.fieldType} not map esType`);
            }
        }
    }
};
