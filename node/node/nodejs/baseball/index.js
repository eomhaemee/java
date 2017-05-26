/**
 * Created by Admin on 2017-05-08.
 */
const ejs = require('ejs');
const express = require('express');
const fs = require('fs');
const bodyParser = require('body-parser');
const path = require('path');
const app = express();

app.use(express.static(__dirname+'/static'));

app.use('/node_modules',express.static(path.join(__dirname,'node_modules')));

app.use(bodyParser.urlencoded({extended: false}));

let teamIndex = 0;
let playerIndex = 0;

const teams=[
    {   teamName:'hanhwa',
        player: [
            {memberName: 'ehm', id: playerIndex++},
            {memberName: 'ehm2', id: playerIndex++}
        ],
        id: teamIndex++
    },
    {   teamName:'samsung',
        player: [
            {memberName: 'osk', id: playerIndex++},
            {memberName: 'osk2', id: playerIndex++}
        ],
        id: teamIndex++
    }
];

//list
app.get('/',function(req,res){
    fs.readFile('main.ejs','utf8',function(err,data){
        res.writeHead(200,{'Content-Type' : 'text/html'});
        res.end(ejs.render(data,{
            teams :teams
        }));
    });
});

//teamAdd
app.post('/addTeam',function(req,res){
    fs.readFile('main.ejs','utf8',function(err,data){
        const team = {};
        let teamName = req.body.teamName;

        team.teamName = teamName;
        team.player = [];
        team.id = teamIndex++;

        teams.push(team);

        console.log(teams);

        res.end('true');
        //res.redirect('/');
    });
});

//memberAdd
app.post('/addMember',function(req,res){
    fs.readFile('main.ejs','utf8',function(err,data){

        let memberName = req.body.memberName;
        let teamId = req.body.teamId;

        const member = {};
        member.memberName = memberName;

        if ( teams[teamId].player.length > 0 ) {
            console.log('length : ', teams[teamId].player.length);
            member.id = teams[teamId].player.length;
        }else{
            console.log('length else : ', 0);
            member.id = 0;
        }

        //member.playerIndex = playerIndex++;

        console.log('test     :         ',teamId);

        teams[teamId].player.push(member);

        console.log(teams);

        res.end('true');
        //   res.redirect('/');
    });
});

//delete
app.post('/delete',function(req,res){

    let teamId = req.body.teamId;
    let playerId = req.body.playerId;
    console.log('전 :  ',teams[teamId].player);
    console.log(teamId,playerId);
    teams[teamId].player.splice(playerId,1);
    console.log('후 :  ',teams[teamId].player);
    res.redirect('/');
});

//detail
app.get('/team/:id',function(req,res){
    let id = req.params.id;

    console.log(teams[id].player);

    fs.readFile('main.ejs','utf8', function(err, data) {
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end(ejs.render(data,{
            teams : teams,
            teamsId : id,
            player: teams[id].player
        }));
    });
});


app.use(function(req,res){
    res.type('text/html');
    res.sendStatus(404);
});

app.use(function(req,res){
    res.type('text/html');
    res.sendStatus(500);
});


app.listen(3000,function(){
    console.log('Server start Baseball');
});