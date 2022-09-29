package com.example.cloudstorageproject.server;

import com.example.cloudstorageproject.connection.AuthMessageSet;
import com.example.cloudstorageproject.connection.RegisterMessageSet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.LinkedList;

public class ClientMessageHandler extends ChannelInboundHandlerAdapter {
    private static String pathOfDirectories = "";
    private static String pathsOfDirectories = "";
    private static LinkedList<File> list = new LinkedList<>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg == null) {
            return;
        } else {
            if (msg instanceof AuthMessageSet) {
                AuthMessageSet authMessage = (AuthMessageSet) msg;
                DBHandler.openConnection();
                if (DBHandler.checkLoginExists(authMessage.getLogin())) {
                    if (DBHandler.checkCorrectPassword(authMessage.getLogin(), authMessage.getPassword())){
                        ctx.writeAndFlush("correctUserData/" + authMessage.getLogin());
                    } else ctx.writeAndFlush("Password isn't correct");
                } else ctx.writeAndFlush("User doesn't exist");
                DBHandler.closeConnection();
            } else if (msg instanceof RegisterMessageSet) {
                RegisterMessageSet registerMessage = (RegisterMessageSet) msg;
                DBHandler.openConnection();
                if (!DBHandler.checkLoginExists(registerMessage.getLogin())) {
                    if (DBHandler.registerNewUser(registerMessage.getLogin(), registerMessage.getPassword())) {
                        File userDirectory = new File("CloudStorageProject/CloudStorage/" + registerMessage.getLogin());
                        userDirectory.mkdir();
                        ctx.writeAndFlush("Success! User is added to system");
                    }
                } else ctx.writeAndFlush("User is already exists");
                DBHandler.closeConnection();
            }
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }

    public static void deleteRecursively(File f) throws Exception {

    }

}
