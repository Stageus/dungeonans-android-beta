package com.example.dungeonans.DataClass

data class BlogData(var cardViewTitle : String, var cardViewBody : String, var cardViewWriter : String, var cardViewProfile : Int)
data class CommunityData(var postTitle : String, var postBody : String, var hashtag : String, var likeCount : String, var commentCount : String)
data class CommentData(var commentBody : String)
data class AnswerData(var writerProfile : Int, var writerName : String, var writerNickName : String, var writeTime : String, var postBody : String)
data class PostCommentData(var commentWriteProfile : Int, var commentWriterName : String, var commentWriterNickname : String, var commentWriteTime : String, var commentBody : String, var like : Int)
data class AskData(var askUserImage : Int, var askUserName : String, var askUserNickname : String, var askPostTitle : String, var askPostBody : String, var askStatusImage : Int, var askPostLikeCount : String, var askCommentCount : String)