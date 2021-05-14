package edu.ada.cms_spring.auth.service;

/**
 * Interface to be implemented by classes offering hashing services.
 */
public interface HashService
{
	String hash(String string);
}
