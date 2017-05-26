/**
 * Created by Admin on 2017-04-28.
 */
var express = require('express');
var router = express.Router();

router.get('/:id',function(request,response){
    var id = request.params.id;

    var items = [
        {name:'eom hae mee', job:'학생'},
        {name:'osk', job:'회사원'}
    ];
    response.type('text/html');
    response.send('<h1>'+items[id].name + '</h1>');
});

exports.router = router;

